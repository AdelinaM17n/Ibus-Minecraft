# Getting ibus working with GLFW
  Setting the evironment variable `GLFW_IM_MODULE=ibus` should enable you to input things with ibus for any GLFW application (assuming they use the charCallback)

# Problems and limitations
  Atleast with an ibus-m17n engine, it open a seperate textbox where you can input your chars, which then will be inputed to Minecraft chat screen when you press a key like backspace or arrow keys or space.
  But this textbox is always listening, you might notice it recording random chars and letting them go while outside of the ChatScreen.
  One side effect of this is that hitting `t` to open the chat screen will put whatever the mapping of `t` is to the ibus textbox, potentially leaving you with a
  annoying unnecessary character at the start that you need to manually remove before you can type what you want.

# Solutions
  For the above mentioned issue a small minecraft mod is included in this repository to automatically remove that char when opening the minecraft chat screen

