# minimal scenery example project
This is a minimal README for a minimal [scenery](https://scenery.graphics) project, on which you can base your own applications.

## Description

The main class of the project resides in `src/main/kotlin/graphics/scenery/MinimalSceneryExample.kt`, while the Gradle build configuration is specified in `build.gradle.kts`. For more details on scenery and sciview, have a look at the [documentation](https://docs.scenery.graphics/) or join the [developer's gitter channel](https://gitter.im/scenerygraphics/sciview).

## Building and running

On the command line, the project can be built by running
```bash
./gradlew build
```

The resulting application, consisting of the single class `MinimalSceneryExample` can then be run via
```bash
./gradlew run
```

Of course, the Gradle project defined in `build.gradle.kts` can also be imported into an IDE such as [IntelliJ](https://www.jetbrains.com/idea).

## License

minimal-scenery-example-project is distributed under a
[Simplified BSD License](http://en.wikipedia.org/wiki/BSD_licenses);
for the full text of the license, see
[LICENSE.txt](https://github.com/imagej/imagej/blob/master/LICENSE.txt).

For the list of ImageJ developers and contributors, see
[the parent POM](https://github.com/imagej/pom-imagej/blob/master/pom.xml).

