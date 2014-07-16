#!/bin/bash
ant debug && ant installd &&  adb shell am start com.mamiaokui.rubbishmessage/com.mamiaokui.rubbishmessage.Main
