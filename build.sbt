import sbt.Keys._

// Settings
val org_monkeynuthead = "org.monkeynuthead"
val proj_version = "1.0.0-SNAPSHOT"
val scalajs_library_name = "tone"
val scala_version = "2.12.3"

lazy val commonSettings = Seq(
  organization := org_monkeynuthead,
  version := proj_version,
  isSnapshot := version.value.endsWith("SNAPSHOT"),
  scalaVersion := scala_version
)

lazy val librarySettings = Seq(
  name := s"scalajs-$scalajs_library_name",
  crossScalaVersions := Seq("2.11.8", scala_version),
  libraryDependencies ++= Seq(
    //    "org.scala-js" %%% "scalajs-dom" % "0.9.2"
  ),
  //  jsDependencies ++= {
  //    val toneJs = "org.webjars.bower" % "tone-js" % "x.x.x"
  //    Seq(RuntimeDOM, toneJs / "dist/tone.min.js")
  //  },
  //FIXME: Work out how to download these in the build, see https://github.com/Tonejs/Tone.js
  jsDependencies += ProvidedJS / "Tone.js",
  //  publishMavenStyle := true,
  //  publishTo := {
  //    val nexus = "https://oss.sonatype.org/"
  //    if (isSnapshot.value)
  //      Some("snapshots" at nexus + "content/repositories/snapshots")
  //    else
  //      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  //  },
  //  publishArtifact in Test := false,
  //  pomIncludeRepository := { _ ⇒ false },
  licenses := Seq("The MIT License" → url("http://opensource.org/licenses/MIT")),
  homepage := Some(url(s"https://github.com/georgenicoll/${name.value}")),
  pomExtra := <scm>
    <url>git@github.com:georgenicoll/
      {name.value}
      .git</url>
    <connection>scm:git:git@github.com:georgenicoll/
      {name.value}
      .git</connection>
  </scm>
    <developers>
      <developer>
        <id>george.nicoll</id>
        <name>George Nicoll</name>
        <url>https://github.com/georgenicoll</url>
      </developer>
    </developers>
)

// Projects
lazy val tone = Project("scalajs-tone", file("tone"))
  .settings(commonSettings, librarySettings)
  .enablePlugins(ScalaJSPlugin)

lazy val test = Project("scalajs-tone-testing", file("testing"))
  .dependsOn(tone)
  .settings(
    commonSettings,
    name := s"scalajs-$scalajs_library_name-testing",
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.2",
      "com.lihaoyi" %%% "utest" % "0.4.4" % "test"
    ),
    skip in packageJSDependencies := false,
    scalaJSUseMainModuleInitializer := true,
    emitSourceMaps in fastOptJS := true,
    relativeSourceMaps := true,
    jsEnv := new org.scalajs.jsenv.selenium.SeleniumJSEnv(
      //requires downloading the chrome driver from
      // http://docs.seleniumhq.org/download/#thirdPartyDrivers
      //and adding it to your PATH
      org.openqa.selenium.remote.DesiredCapabilities.chrome()
    ),
    testFrameworks += new TestFramework("utest.runner.Framework")
  )
  .enablePlugins(ScalaJSPlugin)

lazy val all = Project("scalajs-tone-all", file("."))
  .aggregate(tone, test)
