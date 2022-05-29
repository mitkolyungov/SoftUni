function dividedBy9(input){
    let number1 = Number(input[0]);
    let number2 = Number(input[1]);

    let sum = 0;
    for (let index = number1; index <=number2 ; index++) {
        if(index%9==0){
        sum+=index;
        }
    }
    console.log("The sum: "+sum);

    for (let index = number1; index <=number2 ; index++) {
        if(index%9==0){
        console.log(index);
        }
    }
}