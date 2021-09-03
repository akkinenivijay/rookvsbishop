import Dependencies._

ThisBuild / scalaVersion := "2.13.6"
ThisBuild / version := "0.1.0"
ThisBuild / organization := "com.zushealth"
ThisBuild / organizationName := "zushealth"

lazy val root = (project in file("."))
  .settings(
    name := "RookVsBishop",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test,
    libraryDependencies += "org.scalatest" %% "scalatest-flatspec" % "3.2.9" % Test,
    libraryDependencies += "org.scalatest" %% "scalatest-funsuite" % "3.2.9" % Test,
    libraryDependencies += "org.mockito" % "mockito-scala-scalatest_2.13" % "1.16.39" % Test,
    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-unchecked",
      "-language:implicitConversions",
      "-language:higherKinds",
      "-language:existentials",
      "-language:postfixOps",
      "-encoding utf8",
      "-Xfatal-warnings"
    )
  )
