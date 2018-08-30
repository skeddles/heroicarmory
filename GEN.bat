@echo off
cls
echo Generating Heroic Armory Files
node generateFiles.js
xcopy /s /y textures_overwrite src\main\resources\assets\heroicarmory\textures\items
echo done