function password(input){
    let name = input[0];
    let password = input[1];
    let index = 2;
    let pass = input[index];
    while(true){
        if(pass==password){
            console.log(`Welcome ${name}!`);
            break;
        }
        pass = input[++index];
    }
}