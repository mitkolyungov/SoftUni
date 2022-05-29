function isExcelent(input){
    let password = input[0];
    if(password.localeCompare("s3cr3t!P@ssw0rd")==0){
        console.log("Welcome");
    }else{
        console.log("Wrong password!");
    }
}
