var CARD_NUM = 2,
    $stage = $(".js-stage"),
    $reset = $(".js-reset"),
    $addScore = $(".addscore"),
    $dispScore　= $(".dispScore"),
    $inpScore = $(".less"),
    $btn = $('.inpbtn'),
    $first = undefined,
    firstNum = undefined,
    correctNum = 0,
    flipFlag = true,
    startTime = undefined,
    finishTime = undefined,
    defScore = 20000,
    score = 0;

$reset.on("click", initCards);
$stage.on("click", "li", flipCard);


initCards();

function initCards() {
    initialize();
    $stage.append(getTemplate());
}

function initialize() {
    $stage.html("");
    flipFlag = true;
    correctNum = 0;
    startTime = new Date();
    score = defScore;
}

function getTemplate() {
    var num,
        cardIndex,
        cards = [],
        list = "";

    for (var i = 0; i < CARD_NUM; i++) {
        num = Math.floor(i / 2);
        cardIndex = Math.floor(Math.random() * CARD_NUM);

        if (cards[cardIndex] == undefined) {
            cards[cardIndex] = num;
        } else {
            i--;
        }
    }

    for (var j = 0; j < CARD_NUM; j++) {
        list += '<li data-num="' + cards[j] + '">?</li>';
    }

    return list;
}

function flipCard() {
    if (!flipFlag || $(this).text() != "?") {
        return false;
    }

    var flipNum = $(this).data("num");

    $(this).text(flipNum);

    if (firstNum == undefined) {
        firstNum = flipNum;
        $first = $(this);
    } else {
        flipFlag = false;
        judgeCards($(this), flipNum);
    }
}

function judgeCards($second, secondNum) {
    if (firstNum == secondNum) {
        flipFlag = true;
        correctNum++;

        if (correctNum == CARD_NUM / 2) {
            finishTime = new Date();
            var Time = finishTime - startTime;
            score = score - Time;
            var msg = "点数:"+score+"点";
            alert("クリアー！");
            $reset.css('display','none');
            $stage.css('display','none');
            $dispScore.append('<h3>'+msg+'</h3>');
            $addScore.append('<h4>おなまえ</h4>');
            $addScore.append('<input type="text" id="name"/>');
            $btn.append('<button type="button" class="less" id="sub">投稿</button>');
            $btn.on('click',$inpScore,function(){

                    var name = $('#name').val();
                    console.log(name);
                    //status = sendScore(name,score);
                    alert(name+": "+score);

            });
        }
    } else {
        setTimeout(function() {
            $first.text("?");
            $second.text("?");
            score = score - 100;
            flipFlag = true;
        }, 500);
    }
    firstNum = undefined;
}

