IBM MobileFirst Foundation
===
## Hello Live Update

In the sample application you select a country and using Live Update the app then outputs text in language that corresponds to the selected country.

### Tutorials
https://mobilefirstplatform.ibmcloud.com/tutorials/en/foundation/8.0/using-the-mfpf-sdk/live-update/

### Usage

1. Download and deploy the Live Update adapter [as instructed in the tutorial](https://mobilefirstplatform.ibmcloud.com/tutorials/en/foundation/8.0/using-the-mfpf-sdk/live-update/#adding-live-update-to-mobilefirst-server).
2. Add a scope mapping for **configuration-user-login** in **MobileFirst Operations Console → [your application] → Security tab → Scope-Elements Mapping**.
3. [Import the Live Update schema and segments](https://mobilefirstplatform.ibmcloud.com/tutorials/en/foundation/8.0/using-the-mfpf-sdk/live-update/#import-export) for the sample application:
 * [schema](https://raw.githubusercontent.com/MobileFirst-Platform-Developer-Center/LiveUpdateSwift/release80/schema.txt)
 * [segments](https://raw.githubusercontent.com/MobileFirst-Platform-Developer-Center/LiveUpdateSwift/release80/segments.txt)  
4. From a command-line window, navigate to the project's root folder and run the command `mfpdev app register` to register the application.
5. In Android Studio, run the app in the Android Emulator or a physical device.

> **Tip:** you can update the bundled SDK by running the command `pod update` from the project's root folder.

#### Changing Live Update Settings
Each segment gets the default value from the schema. Change each one according to the language. For example, for French add: **helloText** - **Bonjour le monde**.

In **MobileFirst Operations Console → [your application] → Live Update Settings → Segments tab**, click on the **Properties** link that belongs, for example, to **FR**.
  
* Click the **Edit** icon and provide a link to an image that representes for example the France geography map.
* To see the map while using the app, you need to enable to `includeMap` feature.

#### Note
To be able to immediatly experience changes, go to the **Live Update Settings** configuration tab and set the `expirationPeriod` to a smaller value (e.g: 5 seconds).

## Supported Versions
IBM MobileFirst Foundation 8.0

## Licence
Copyright 2016 IBM Corp.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
