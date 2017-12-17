resolvers +=
  "Artifactory" at "http://virgo.fun:8081/artifactory/sbt-repo-local/"

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

libraryDependencies += "markarasev" %% "jvm-utils" % "0.2"

scalafmtOnCompile in ThisBuild := true
