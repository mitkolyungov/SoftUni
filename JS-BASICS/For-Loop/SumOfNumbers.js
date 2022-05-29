function vowelsSum(input){
    let text = input[0];
    let sum = 0;
    for (let index = 0; index <text.length ; index++) {
        let letter = text.charAt(index);
        sum+=Number(letter);
    }
    console.log("The sum of the digits is: "+sum);

}
