# ArchiveManager

<h3> WHAT IS THIS? </h3>

<p> This is a Java Swing GUI that uses JSON files to track my downloaded tv series. The files are read and written to using GSON.

The JSON files have a simple structure: </p>

```
{
  "seriesName": "Don Matteo",
  "seriesStatus": true,
  "seriesLink": "totallylegitwebsite.com"
}
```

---


<h4><i> HOW TO CREATE A SHORTCUT </i></h4>

<p> After building the project you may want to create a .bat file, just like this one: </p>

```
java -jar nameofyourjar.jar
```

<p> Right click the .bat file then press the <i>Send to</i> button, after that click <i>Desktop (create shortcut)</i>.
Now go on your desktop and right click the shortcut. A menu will appear and you need to click on <i>Properties</i>. Then in the <i>Run</i> dropdown menu choose <i>Minimized</i>. From here you can also change the icon of your shortcut. </p>
