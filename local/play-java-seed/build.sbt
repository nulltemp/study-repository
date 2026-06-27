name := """play-java-seed"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.18"

libraryDependencies += guice
libraryDependencies ++= Seq(evolutions, jdbc)
libraryDependencies += "com.h2database" % "h2" % "2.4.240"
