import Dependencies._

ThisBuild / scalaVersion := "2.13.6"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.zushealth"
ThisBuild / organizationName := "zushealth"

lazy val root = (project in file("."))
  .settings(
    name := "RookVsBishop",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.28" % Test,
    testFrameworks += new TestFramework("munit.Framework"),
    scalacOptions ++= Seq("-deprecation", "-feature")
  )
