# FlickrImageSearch

FlickrImageSearch is as simple app used to search image's. The image thumbnails are displayed on gridview.


# Developer's Note

FlickrImageSearch is developer without using any third party library and the app is based on MVVM and Singleton design pattern. Below is the helper files short description.

## Helper Files

```
HttpRequestTask.class - inside data package helps to fetch data from url using HttpURLConnection connection class and read stream using BufferedReader class.
```

```
DownloadImageTask.class - inside data package helps to load bitmap data from url using HttpURLConnection connection class and decode input stream to bitmap.
```

```
BitmapCache.class - inside data > utils package helps to cache bitmap which was loaded using HttpURLConnection and stored it to save network time and we can get bitmap from cache whenever required.
```

```
JsonParser.class - inside data > utils package helps to parse flickr api response json data to FlickrApiResponse object.
```

```
URLBuilder.class - inside data > utils package helps to build flickr api endpoint by concating page number and query string in BASE URL. It also helps to build image endpoint.
```

# Usage

To use this project clone it from the below URL

* **https://github.com/CHIRANJIT1988/flickr-image-search-android-mvvm.git**


## LICENSE

```
Copyright 2017 Chiranjit

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```
"# VipinFlickr" 
