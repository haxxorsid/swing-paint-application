
What is Swing Paint Application ?
---------

A basic paint application based on Java swing made for University as a Mini-project. 

Features
---------

1. Draw strokes with pencil tool and set thickness.
2. 11 Quick color selection buttons.
3. Provided with Color Picker (Swatches, HSV, HSL, RGB, CMYK) using JColorChooser.
4. Small size, easy-to-understand code.
5. Save, Save As, Load buttons to Save/Load you work using Interactive JFileChooser.
6. Undo, Redo
7. Nimbus Look and Feel theme.
8. Set Canvas size. ( Minimum recommended: 900x800)

Screenshots
---------

Setting Canvas Size

![OptionPane for setting canvas size](http://image.prntscr.com/image/844aa705dcd84a258d78142ad9960d66.jpg "Set Canvas Size")

Paint Application

![Application](http://image.prntscr.com/image/786b1e5405db446db4eca6f6529d6b58.jpg "Application")

Save, Save as and Load. ( JFileChooser)

![Save Window](http://image.prntscr.com/image/3489f55101a04ca986b95f2ac80c9082.jpg "Save Window")
![Load Window](http://image.prntscr.com/image/597a1c353830430b90c87e63d43ee89f.jpg "Load Window")

Color Picker ( JColorChooser)

![Color Picker](http://image.prntscr.com/image/30651492ee864a008ea235b24e6ad278.jpg "Color Picker")

###How to use this repository

* Fork it.

Easy way (for newbs):
* Click on Clone or download  button in top right corner.
* Download zip.
* Extract.
* Open eclipse or any IDE and Import project.
* Run InputWH.java.
* If you're experiencing NullPointerException issue regarding images, the images stored in /bin folder might not be downloaded, so please download them manually from this repository from bin folder and link/copy those images with your project in eclipse.

Other way: 
[Directly from Git to Eclipse](http://stackoverflow.com/questions/6760115/importing-a-github-project-into-eclipse)

Recommended way:
* Create a branch (```git checkout -b my_branch```)
  * Using Eclipse make a workspace on the top directory of 'Swing-Paint-Application'
  * Create new project
  * Name the Project SwingPaint
  * Press next and click the Libraries tab
  * Click Add Class Folder
  * Check the /res folder and hit finish
  * Make the changes in the /src folder
* Commit your changes (```git commit -m "Change Title"```)
* Push to the branch (```git push origin my_branch```)
* Open a [Pull Request](https://github.com/haxxorsid/Swing-Paint-Application/pull/new/master)

###Note

All icons used in the project are placed in /bin folder. So if you're experiencing any NullPointerException issue, please link/copy those image files in your project properly.
