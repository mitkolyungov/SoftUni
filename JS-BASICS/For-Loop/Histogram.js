function histogram(input){
    let numbers = Number(input[0]); 

    let p1 = 0;
    let p2 = 0;
    let p3 = 0;
    let p4 = 0;
    let p5 = 0;

    for (let index = 1; index <=numbers; index++) {
        let number = input[index];

        if(number >= 0 && number<200){
            p1++;
        }else if(number >= 200 && number<=399){
            p2++;
        }else if(number >= 400 && number<=599){
            p3++;
        }else if(number >= 600 && number<=799){
            p4++;
        }else if(number >= 800){
            p5++;
        }
        
    }

    console.log((p1/numbers*100).toFixed(2)+"%");
    console.log((p2/numbers*100).toFixed(2)+"%");
    console.log((p3/numbers*100).toFixed(2)+"%");
    console.log((p4/numbers*100).toFixed(2)+"%");
    console.log((p5/numbers*100).toFixed(2)+"%");
}