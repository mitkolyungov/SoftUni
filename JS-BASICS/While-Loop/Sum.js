function sum(input){
    let targetSum = Number(input[0]);

    let index = 1;
    let sum = 0;

    while(sum<targetSum){
        sum+=Number(input[index++]);
    }

    console.log(sum);
}