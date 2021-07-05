function calculate() {
    var h = document.querySelector("#heightNumber").value;
    var w = document.querySelector("#widthNumber").value;

    document.querySelector("#result-c").innerHTML = (Number(h) + Number(w)) * 2;
    document.querySelector("#result-s").innerHTML = Number(h) * Number(w);
}