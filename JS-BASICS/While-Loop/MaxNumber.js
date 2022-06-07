function findMaxNumber(input){
    let maxNumber = Number.MIN_SAFE_INTEGER;
    let index = 0;
    let command  = input[index];

    while(command!=="Stop"){
        let number = Number(command);

        if(number>maxNumber){
            maxNumber = number;
        }
        index++;
        command = input[index];
    }

    console.log(maxNumber);
}