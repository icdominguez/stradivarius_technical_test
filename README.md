# Stradivarius Technical Test App

This app was made for the technical test for Stradivarius.

Here's the screenshots and a short video of the app:

<table align="center">
	<tr>
    <td><img src="https://github.com/icdominguez/stradivarius_technical_test/assets/56835908/9bd883d0-57d3-4a4d-9728-3cafe839a798" width="350" title="hover text"></td>
    <td><img src="https://github.com/icdominguez/stradivarius_technical_test/assets/56835908/ad9c4633-8ee9-46ec-8f37-bca60588d66c" width="350" title="hover text"></td>
  </tr>
  <tr>
    <td><img src="https://github.com/icdominguez/stradivarius_technical_test/assets/56835908/c75b0b95-8044-4d4b-8894-b287faf81a5b" width="350" title="hover text"></td>
    <td><img src="https://github.com/icdominguez/stradivarius_technical_test/assets/56835908/7d73c0ab-6173-480d-89cc-ee1032a97590" width="350" title="hover text"></td>
  </tr>
</table>

https://github.com/icdominguez/stradivarius_technical_test/assets/56835908/cb86ddab-e4ac-4fa0-bf7b-e113f41d0ab1

The app consists of making a request to [Randomuser API (https://randomuser.me/)] and following the design patterns specified by the company, make an app that prints the users and a detail of them.

For this app, I used the following libraries

- [Hilt](https://dagger.dev/hilt/) - Dependency Injection library.
- [Jetpack](https://developer.android.com/jetpack)
- [Android KTX](https://developer.android.com/kotlin/ktx.html) - Provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android.
- [AndroidX](https://developer.android.com/jetpack/androidx) - Major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
- [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
- [Compose Navigation](https://developer.android.com/jetpack/compose/navigation) -Component that allows easier implementation of navigation from composables.


- [Retrofit](https://square.github.io/retrofit/) - Type-safe http client 
and supports coroutines out of the box.  

- [OkHttp-Logging-Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - Logs HTTP request and response data.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines.
- [Flow](https://developer.android.com/kotlin/flow) - Flows are built on top of coroutines and can provide multiple values. A flow is conceptually a stream of data that can be computed asynchronously.

All the dependencies (external libraries) are defined in a single place - (libs.versions.toml)
file using [Version Catalogs](https://docs.gradle.org/current/userguide/platforms.html). This approach allows us to easily manage dependencies and use the same dependency version across
all modules.

and followed the resources above:

1. [Now in android repository](https://github.com/android/nowinandroid)
2. [Guide to Android app modularization](https://www.youtube.com/watch?v=16SwTvzDO0A&ab_channel=AndroidDevelopers)
3. [Conventions](https://docs.gradle.org/current/samples/sample_convention_plugins.html)
4. [Build-src](https://medium.com/codex/clean-dependency-management-in-multi-module-android-projects-49f2a0df8d2f)

The app is multi modularized, for doing it more quickly and organized I decided to create a build Logic Module to share dependencies between modules and creating conventions plugins, according to the google specifications(resources included)

For the logic of the app I decided to use 4 BIG module categories_

- CORE: That contains 3 modules:
  - Common: Contains al the things exposed to other modules that will need it.
  - Design system: Contains all the logic for the ui (themes, colors, typography etc)
  - Model: It's a jvm library with all the classes for the model that will be consumed by other modules.
  - Network: This is the bigger module in the Core folder, it contains all the logic for making a request to the API
- DATA: Contains mappers, repository and the specified utilities a feature has. need to create a module inside data for every feature we have (if needed)
- DOMAIN: Contains the uses cases need for a feature. need to create a module inside domain for every feature we have (if needed)
- FEATURE: A module for every screen or new funtionality to develop (every single module contains its own navigation that will be called from the app module):
  - Contacts: Which contains the composables, viewmodels and deserializer.
  - Detail: Which contains the composables, viewmodels and serializer.
  - Maps: Contains the logic for implementing a map. Exposed it to other modules.
 
I tried to follow the clean architecture as sepecified here: 

<img src="https://github.com/icdominguez/stradivarius_technical_test/assets/56835908/c9ce7560-2aa6-4b7f-bd71-f24480916b70" width="250"/> 

and the mvi in the presentation (features) layer: https://www.scaler.com/topics/mvi-architecture-android/
 

