# GDX_SSCCE_ANY_KEY
SSCCE of the any key bug on Linux, libgdx

After dragging the application window, the `Gdx.input.isKeyPressed()` method always returns false when `Input.Keys.ANY_KEY` is passed as parameter.

#### Issue details
I'm not familiar with the libgdx codebase enough, but I think the `pressedKeys` value stops being updated at a certain point for whatever reason. This is also a platform specfic issue. I tested the same program on Windows 7 and it works as expected.

#### Reproduction steps/code
[SSCCE That demostrates the issue.](https://github.com/nhatzHK/GDX_SSCCE_ANY_KEY/).

1. Clone the repository linked above.
2. Run the desktop launcher.
3. Press left, right, up, down, and space keys to verify that the image moves.
4. Drag the window either with your mouse or a key combination.
5. Repeat step 3.

**Expected behaviour:** At step 5 the program behaves like in step 3 with key presses moving the image inside the application window.

**Observed behaviour:** At step 5, the program keeps running normally, but `Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)` [always returns false](https://github.com/nhatzHK/GDX_SSCCE_ANY_KEY/blob/c3b52d43313bc806571a438e818a39ba59c2c7c4/core/src/com/mygdx/game/SSCCE_Screen.java#L30) even though [input is still correctly processed](https://github.com/nhatzHK/GDX_SSCCE_ANY_KEY/blob/c3b52d43313bc806571a438e818a39ba59c2c7c4/core/src/com/mygdx/game/SSCCE_Screen.java#L59). 

#### Version of LibGDX and/or relevant dependencies
_libgdx 1.9.8_

#### Environment
**OS:** Linux
**Kernel:** x86_64 Linux 4.14.15-1-ARCH
**WM:** i3wm
**CPU:** Intel Core i7-5600U @ 4x 3.2GHz
**GPU:** Mesa DRI Intel(R) HD Graphics 5500 (Broadwell GT2)

#### Affected platforms
- [ ] Android
- [ ] iOS (robovm)
- [ ] iOS (MOE)
- [ ] HTML/GWT
- [ ] Windows
- [x] Linux
- [ ] MacOS
