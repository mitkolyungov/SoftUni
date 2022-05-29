function isExcelent(input){

    let city = input[0];
    let sales = Number(input[1]);   
    if(sales<0){
        console.log("error");
        return;
    }
    let sum = 0;
    
    if(city == ("Sofia")){
        if(sales>=0 && sales<=500){
            sum = 0.05*sales;
        }else if(sales>500 && sales<=1000){
            sum = 0.07*sales;
        }else if(sales>1000 && sales<=10000){
            sum = 0.08*sales;
        }else{
            sum = 0.12*sales;
        }
        console.log(sum.toFixed(2));
    }else if(city == ("Varna")){
        if(sales>=0 && sales<=500){
            sum = 0.045*sales;
        }else if(sales>500 && sales<=1000){
            sum = 0.075*sales;
        }else if(sales>1000 && sales<=10000){
            sum = 0.1*sales;
        }else{
            sum = 0.13*sales;
        }
        console.log(sum.toFixed(2));
    }else if(city == ("Plovdiv")){
        if(sales>=0 && sales<=500){
            sum = 0.055*sales;
        }else if(sales>500 && sales<=1000){
            sum = 0.08*sales;
        }else if(sales>1000 && sales<=10000){
            sum = 0.12*sales;
        }else{
            sum = 0.145*sales;
        }
        console.log(sum.toFixed(2));
    }else{
        console.log("error")
    }
  
}



    
    