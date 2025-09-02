# This is a simple start-up script for the bot
# i thoight i'd include it here so anyone 
# else can use it if they want
# note that you will need all the libs too

#!/bin/bash

SRC_DIR="src/main"
OUT_DIR="out"
MAIN_CLASS="net.amar.main"

mkdir -p $OUT_DIR

BOT_PID=""

color_echo() {
    color=$1
    text=$2
    echo -e "\e[${color}m${text}\e[0m"
}

start_bot() {
    color_echo "94" "[*] Deleting old compiled classes..."
    rm -rf "$OUT_DIR/amar"

    color_echo "94" "[*] Compiling..."
    javac -cp "lib/*" -d "$OUT_DIR" $(find "$SRC_DIR" -name "*.java")

    if [ $? -eq 0 ]; then
        color_echo "32" "[*] Starting bot..."
        java -cp "$OUT_DIR:lib/*" $MAIN_CLASS &
        BOT_PID=$!
        echo -e "\e[32m[*] Bot running with PID \e[37m$BOT_PID\e[0m"
    else
        color_echo "31" "[*] Compilation failed. Waiting for changes..."
    fi
}

# Initial run
start_bot
