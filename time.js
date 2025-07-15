function printFancyTime() {
    const now = new Date();

    // Get the hours, minutes, and seconds
    const hours = String(now.getHours()).padStart(2, "0");
    const minutes = String(now.getMinutes()).padStart(2, "0");
    const seconds = String(now.getSeconds()).padStart(2, "0");

    // Use emojis and custom formatting
    const fancyTime = `⏰ ${hours} 🕒 ${minutes} 🕒 ${seconds}`;
}
// line modified
setInterval(printFancyTime, 1000);
 // new line added