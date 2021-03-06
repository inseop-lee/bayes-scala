# Bayesian Networks in Scala 

[![Join the chat at https://gitter.im/danielkorzekwa/bayes-scala](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/danielkorzekwa/bayes-scala?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Build Status](https://travis-ci.org/danielkorzekwa/bayes-scala.svg)](https://travis-ci.org/danielkorzekwa/bayes-scala)
[![Codacy Badge](https://www.codacy.com/project/badge/2a48694cabbe4cd386af1be55602cbbf)](https://www.codacy.com/public/danielkorzekwa/bayes-scala)

It is a Scala library for Bayesian Networks and Probabilistic Graphical Models. It allows for defining Baysian models and performing Bayesian inference in a number of ways:

* [DSL] - This is a high level api for defining Bayesian Networks. 
* [Factor graph] - It supports discrete and continuous variables. Inference is performed with Expectation Propagation.
* [Factor graph 2] - Different (newer) implemenation of factor graph.
* [Cluster graph] - Supports discrete variables only.

The [bayes-scala-gp] library for Gaussian Processes is built on top of bayes-scala.

Links
* [Some code examples for moment matching, linear gaussian, linear dynamical systems, EP, etc.]
* [Can you please clarify for us: what is the future of bayes-scala?](https://github.com/danielkorzekwa/bayes-scala/blob/master/doc/future_of_bayes_scala.md) 

## How to use it from sbt and maven?

### Release version

SBT configuration: 

```scala
libraryDependencies += "com.github.danielkorzekwa" %% "bayes-scala" % "0.6"  
```

Maven configuration:

```scala  
  <dependencies>
    <dependency>
      <groupId>com.github.danielkorzekwa</groupId>
      <artifactId>bayes-scala_2.11</artifactId>
      <version>0.5</version>
    </dependency>
  <dependencies>
```

### Snapshot version

Snapshot artifact is built by a Travis CI and deployed to Sonatype OSS Snapshots repository with every commit to Bayes-scala project. 

With sbt build tool, add to build.sbt config file:

```scala
libraryDependencies += "com.github.danielkorzekwa" %% "bayes-scala" % "0.7-SNAPSHOT"  

resolvers += Resolver.sonatypeRepo("snapshots")
```

With maven build tool, add to pom.xml config file:

```scala
  <repositories>
    <repository>
      <id>oss-sonatype-snapshots</id>
      <name>oss-sonatype-snapshots</name>
      <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
    </repository>
  </repositories>
  
  <dependencies>
    <dependency>
      <groupId>com.github.danielkorzekwa</groupId>
      <artifactId>bayes-scala_2.11</artifactId>
      <version>0.7-SNAPSHOT</version>
    </dependency>
  <dependencies>
```

[DSL]: https://github.com/danielkorzekwa/bayes-scala/blob/master/doc/dsl/dsl.md
[Factor graph]: https://github.com/danielkorzekwa/bayes-scala/blob/master/doc/factorgraph/factorgraph.md
[Factor graph 2]: https://github.com/danielkorzekwa/bayes-scala/blob/master/doc/factorgraph2/factorgraph2.md
[Cluster graph]: https://github.com/danielkorzekwa/bayes-scala/blob/master/doc/clustergraph/clustergraph.md
[Some code examples for moment matching, linear gaussian, linear dynamical systems, EP, etc.]:https://github.com/danielkorzekwa/bayes-scala/blob/master/doc/others/others.md
[Low level algorithms]: https://github.com/danielkorzekwa/bayes-scala/blob/master/doc/lowlevel/README.md
[bayes-scala-gp]: https://github.com/danielkorzekwa/bayes-scala-gp/blob/master/README.md