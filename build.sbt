organization := "com.darrenbishop"

name := "mercator-shopping-cart"

version := "0.1.0"

scalaVersion := "2.13.6"

run / connectInput := true

run / fork := true

Test / fork := true

scalacOptions ++= Seq(
  "-target:jvm-1.8",
  "-Xmigration",
  "-deprecation",
)

javacOptions ++= Seq(
  "-source", "1.8",
  "-target", "1.8"
)

libraryDependencies ++= Seq(
  "org.scalatest"  %% "scalatest"               % "3.1.2"  % Test,
  "org.scalacheck" %% "scalacheck"              % "1.14.0" % Test,
  "org.mockito"    %% "mockito-scala"           % "1.5.12" % Test,
  "org.mockito"    %% "mockito-scala-scalatest" % "1.5.12" % Test
)
