When the marketplace server is first started it will initialize with some data. All of which can be found in the sibling folders of the *org.dawnsci-marketplace-server* archive file.

## Static content

Static content, such as the welcome text and user guide can be placed in the "pages" folder. These files must be written Markdown format. There is one predefined file named "welcome.md". This holds the text that is shown at the top on the front page.

Links can be written as for example `[user guide](/pages/user_guide.md)`, which will link to Markdown file that will be rendered as HTML. It is also possible to link to other resources:

* `/pages/eclipse.png` an image file.
* `/content/123` the solution with the identifier "123"
* `/files/123/screenshot.png` a file belonging to the solution.   