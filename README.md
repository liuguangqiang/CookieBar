Cookie
==============================================
CookieBar is a lightweight library for showing a brief message at the top or bottom of the screen.

## Screenshot
<img src="arts/default.gif" width="30%"> <img src="arts/custom.gif" width="30%">

## Usage
### Gradle

```
dependencies {
   	compile 'com.liuguangqiang.cookie:library:0.1'
}
```

### Maven
```
<dependency>
  <groupId>com.liuguangqiang.cookie</groupId>
  <artifactId>library</artifactId>
  <version>0.1</version>
  <type>aar</type>
</dependency>
```

## A simple CookieBar.
```
 new CookieBar.Builder(MainActivity.this)
                        .setTitle("TITLE")
                        .setMessage("MESSAGE")
                        .show();
```

## A CookieBar with a icon and a action button.
```
 new CookieBar.Builder(MainActivity.this)
                        .setTitle("TITLE")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage("MESSAGE")
                        .setAction("ACTION", new OnActionClickListener() {
                            @Override
                            public void onClick() {
                            }
                        })
                        .show();
```

## Custom Style
 * layoutGravity
 * backgroundColor
 * titleColor
 * messageColor
 * actionColor
 * duration

## License

    Copyright 2017 Eric Liu

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.