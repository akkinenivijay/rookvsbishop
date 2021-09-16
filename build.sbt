import Dependencies._

ThisBuild / scalaVersion := "2.13.6"
ThisBuild / version := "0.5.0-SNAPSHOT"
ThisBuild / organization := "com.akkineni"
ThisBuild / organizationName := "Akkineni Inc"
ThisBuild / organizationHomepage := Some(url("https://akkineni.org"))
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

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
      "-Xfatal-warnings",
      "-Wunused"
    )
  )
