function sequence(input){
    let number = Number(input[0]);
    let num = 1;
    while(num<=number){
        console.log(num);
         num = 2*num + 1;
    }
}