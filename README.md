IBM MobileFirst Foundation
===
## Hello Live Update

In the sample application you select a country and using Live Update the app then outputs text in language that corresponds to the selected country.

### Tutorials
https://mobilefirstplatform.ibmcloud.com/tutorials/en/foundation/8.0/using-the-mfpf-sdk/live-update/

### Usage

1. Download and deploy the Live Update adapter [as instructed in the tutorial](https://mobilefirstplatform.ibmcloud.com/tutorials/en/foundation/8.0/using-the-mfpf-sdk/live-update/#adding-live-update-to-mobilefirst-server).
2. Add a scope mapping for **configuration-user-login** in **MobileFirst Operations Console → [your application] → Security tab → Scope-Elements Mapping**.
3. Import the Live Update schema for the sample
  * [Click to download](https://www.github.com/MobileFirst-Platform-Developer-Center/LiveUpdateSwift/blob/release80/scheme.txt) the scheme for the sample
  * [Follow the instructions in the tutorial](https://mobilefirstplatform.ibmcloud.com/tutorials/en/foundation/8.0/using-the-mfpf-sdk/live-update/#import-export) to upload the schema
3. Add segments:
  * In **MobileFirst Operations Console → [your application] → Live Update Settings → Segments tab**, add the following segments IDs:
  
  1. DE
  2. FR
  3. ES
  4. UK
  5. IT
  6. US

  Each segment gets the default value from the schema. Change each one according to the language. For example, for French add: **helloText** - **Bonjour le monde**.

6. From a command-line window, navigate to the project's root folder and run the command `mfpdev app register` to register the application.
7. In Android Studio, run the App.

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
