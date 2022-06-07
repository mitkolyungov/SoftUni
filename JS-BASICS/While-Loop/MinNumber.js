function findMinNumber(input){
    let minNumber = Number.MAX_SAFE_INTEGER;
    let index = 0;
    let command  = input[index];

    while(command!=="Stop"){
        let number = Number(command);

        if(number<minNumber){
            minNumber = number;
        }
        index++;
        command = input[index];
    }

    console.log(minNumber);
}