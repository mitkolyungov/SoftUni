function greetingByNmae(input){
    let chickenMenus = (Number)(input[0]);
    let fishMenus = (Number)(input[1]);
    let vegiterianMenu = (Number)(input[2]);
    let delivery = (Number)(2.5);

    let chickenMenusPrice = chickenMenus*10.35;
    let fishMenusPrice = fishMenus*12.40;
    let vegiterianMenuPrice = vegiterianMenu*8.15;

    let totalSum = chickenMenusPrice+fishMenusPrice+vegiterianMenuPrice;

    let desert = totalSum*0.2;

    console.log(totalSum+desert+delivery);
}
