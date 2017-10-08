import sbt.Keys._

// Settings
val scalaJsLibraryName: String = "tone"

lazy val commonSettings = Seq(
  organization := "org.monkeynuthead",
  version := "1.0.0",
  isSnapshot := version.value.endsWith("SNAPSHOT"),
  scalaVersion := "2.12.3"
)

lazy val librarySettings = Seq(
  name := s"scalajs-$scalaJsLibraryName",
  crossScalaVersions := Seq("2.11.8", "2.12.3"),
//  libraryDependencies ++= Seq(
//    "org.scala-js" %%% "scalajs-dom" % "0.9.2"
//  ),
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
    <url>git@github.com:georgenicoll/{name.value}.git</url>
    <connection>scm:git:git@github.com:georgenicoll/{name.value}.git</connection>
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
lazy val tone = Project("scalajs-tone", file("."))
  .settings(commonSettings, librarySettings)
  .enablePlugins(ScalaJSPlugin)
