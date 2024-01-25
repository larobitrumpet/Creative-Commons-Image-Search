# Creative Commons Image Search
**Creative Commons changed their API and thus this application is now broken**

This is a graphical javafx application that I made for my final in my Programing Concepts and Methedology II class. This application searches for images with a Creative Commons license or is in the public domain. This is achieved through the Creative Commons api. The Creative Commons website can be found here: [https://creativecommons.org](https://creativecommons.org).

## Dependencies
`curl` must be installed and in your path.

You need to get a brearer token for the Creative Commons api. Instructions for obtaining a brearer token can be found here: [https://api.creativecommons.engineering/v1/#operation/register_api_oauth2](https://api.creativecommons.engineering/v1/#operation/register_api_oauth2). In CCISModel.java, replace the string "put brearer token here" with your brearer token.

## Build
The application can be build by running `make`. Be sure to run `make clean` between builds.

## Test
JUnit tests are available by running `make test`.

## Usage
The application can be run be running `make run`. On the right, there will be various filters that can be set by checking the corresponding check boxes. At the top, there is a text field and a "Search" button. Type your query into the text field and hit the "Search" button. Below that, you will see the search results. It might take a while for the results to show up, so don't worry if you don't see anything right away. For each result, you will see an image, the name of the image, the copyright of the image, and two buttons marked "Download" and "More Info". Hitting "Download" will download the corresponding image. Hitting "More Info" will open a window with more information about the image. Here you will see the image, the name of the image, the name of the author, the author's website, the copyright of the image, and the attribution (if any). There will also be a "Download" button that will download the image.
