function cake(input) {
    let length = Number(input.shift());
    let width = Number(input.shift());
    let area = length * width;
    let total = 0;
    while (area >= total) {
        let current = input.shift();

        if (current == "STOP") {
            break;
        }
        let piece = Number(current);
        total += piece;
    }
    if (total > area) {
        let need = total - area;
        console.log(`No more cake left! You need ${need} pieces more.`);
    } else {
        let left = area - total;
        console.log(`${left} pieces are left.`);
    }
}