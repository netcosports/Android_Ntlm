# Android_Ntlm
NT LAN Manager (NTLM) implementation for Okhttp

**Min SDK:** 15

## Installation

TapTargetView is distributed using [jitpack.io](https://jitpack.io/).

```groovy
   allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
   
   dependencies {
	        implementation 'com.github.netcosports:Android_Ntlm:1.0'
	}
```

### Simple usage

```java
OkHttpClient client = new OkHttpClient.Builder()
                .authenticator(new NTLMAuthenticator(userName, password, null))
                .build();
```
