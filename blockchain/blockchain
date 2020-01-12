
(* -------------------------------------------------------------------------------- *)
(* ---------------------------------- BLOCKCHAIN ---------------------------------- *)
(* -------------------------------------------------------------------------------- *)

(*
REPOSITORIO: https://github.com/rafaritter44/blockchain

REFERENCIAS:
* Stack Overflow
* https://learnxinyminutes.com/docs/standard-ml/
* https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa
* http://sml-family.org/Basis/overview.html
* https://groups.google.com/forum/#!topic/comp.lang.ml/n5gQDhyW2XY
* https://stackoverflow.com/questions/7548139/sml-nj-while-loop
* http://www.metamorphosite.com/one-way-hash-encryption-sha1-data-software
* https://www.devmedia.com.br/json-tutorial/25275
*)

(* --------------------------------------------------------------------------------- *)
(*										     *)
(* ----------------------------------- ESTRUTURA ----------------------------------- *)

type bloco = {hash:string, hashanterior:string, dados:string, nonce:int};

fun gethash ({hash=h, hashanterior=_, dados=_, nonce=_} : bloco) = h;

fun gethashanterior ({hash=_, hashanterior=ha, dados=_, nonce=_} : bloco) = ha;

fun getdados ({hash=_, hashanterior=_, dados=d, nonce=_} : bloco) = d;

fun getnonce ({hash=_, hashanterior=_, dados=_, nonce=n} : bloco) = n;

type cadeia = bloco list;

fun addbloco (b:bloco, []) = [b]:cadeia
  | addbloco (b:bloco, c:cadeia) = b::c:cadeia;

fun add ([], n) = [n]
  | add (x::xs, n) = x::add (xs, n);

fun getultimobloco [] = {hash="",hashanterior="",dados="",nonce=0}
  | getultimobloco (b::bs) = b;

(* -------------------------------------------------------------------------------- *)
(*										    *)
(* ------------------------------------- JSON ------------------------------------- *)

fun escrever (nomearquivo, conteudo) =
let
	val arquivo = TextIO.openOut nomearquivo
	val _ = TextIO.output (arquivo, conteudo)
in
	TextIO.closeOut arquivo
end;

fun ler nomearquivo =
let
	val arquivo = TextIO.openIn nomearquivo
	val conteudo = TextIO.inputAll arquivo
	val _ = TextIO.closeIn arquivo
in
	conteudo
end;

fun blocotojson b =
let
	val hash = gethash b
	val hashanterior = gethashanterior b
	val dados = getdados b
	val nonce = getnonce b
in
	"  {\n    \"hash\": \"" ^ hash ^
	"\",\n    \"hashanterior\": \"" ^ hashanterior ^
	"\",\n    \"dados\": \"" ^ dados ^
	"\",\n    \"nonce\": " ^ Int.toString nonce ^ "\n  }"
end;

fun tojson c = "[\n" ^ String.concatWith ",\n" (map blocotojson (rev c)) ^ "\n]";

fun tonumero [] = 0
  | tonumero (#":"::xs) = valOf (Int.fromString (implode xs))
  | tonumero (x::xs) = tonumero xs;

fun tovalor (#":"::(#" "::(#"\""::xs)), s) = tovalor (xs, "")
  | tovalor (#"\""::(#","::xs), s) = {valor = s, resto = xs}
  | tovalor (#"\""::(#"}"::xs), s) = {valor = s, resto = xs}
  | tovalor (x::xs, s) = tovalor (xs, s ^ Char.toString x)
  | tovalor ([], s) = {valor = "", resto = []};

fun tobloco (#"{"::xs, ys) = tobloco (xs, [])
  | tobloco (#"}"::xs, ys) = {bloco = add (ys, #"}"), resto = xs}
  | tobloco (x::xs, ys) = tobloco (xs, add (ys, x))
  | tobloco ([], ys) = {bloco = [], resto = []};

fun tocadeia ([], ys) = ys
  | tocadeia (xs, ys) = if #bloco (tobloco (xs, [])) = [] then ys else
let
	val blocoeresto = tobloco (xs, [])
	val b = #bloco blocoeresto
	val r = #resto blocoeresto
	val hasheresto = tovalor (b, "")
	val hash = #valor hasheresto
	val hashanterioreresto = tovalor (#resto hasheresto, "")
	val hashanterior = #valor hashanterioreresto
	val dadoseresto = tovalor (#resto hashanterioreresto, "")
	val dados = #valor dadoseresto
	val nonce = tonumero (#resto dadoseresto)
	val bloco = {hash, hashanterior, dados, nonce}
	val cadeia = addbloco (bloco, ys)
in
	tocadeia (r, cadeia)
end;

fun fromjson s = tocadeia (explode s, []);

(* --------------------------------------------------------------------------------- *)
(*										     *)
(* ------------------------------------- SHA-1 ------------------------------------- *)

fun add1rev (#"0"::cs) = #"1"::cs
  | add1rev (#"1"::cs) = #"0"::add1rev cs
  | add1rev [] = [#"1",#"0",#"0",#"0",#"0",#"0",#"0",#"0"];

fun tobinariorev 0 = [#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0"]
  | tobinariorev n = add1rev (tobinariorev (n - 1));

fun tobinario n = rev (tobinariorev n);

fun add0saux (cs, d) = if length cs <= d
	then d - length cs
else
	add0saux (cs, d + 512);

fun zeroschar n =
let
	val counter = ref 0
	val value = ref []
in
	while (!counter < n) do 
	(counter := !counter + 1; 
	value := #"0"::(!value));
	!value
end;

fun add0s cs =
let
	val n = add0saux (cs, 448)
in
	cs @ zeroschar n
end;

fun add1rev64 (#"0"::cs) = #"1"::cs
  | add1rev64 (#"1"::cs) = #"0"::add1rev64 cs
  | add1rev64 [] = [#"1",#"0",#"0",#"0",#"0",#"0",#"0",#"0",
	#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0",
	#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0",
	#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0",
	#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0",
	#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0",
	#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0",
	#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0"];

fun tobinariorev64 0 = [#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0",
	#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0",
	#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0",
	#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0",
	#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0",
	#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0",
	#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0",
	#"0",#"0",#"0",#"0",#"0",#"0",#"0",#"0"]
  | tobinariorev64 n = add1rev64 (tobinariorev64 (n - 1));

fun tobinario64 n = rev (tobinariorev64 n);

fun chunks [] = []
  | chunks (x0::x1::x2::x3::x4::x5::x6::x7::x8::x9::x10::x11::x12::x13::x14::x15::
	x16::x17::x18::x19::x20::x21::x22::x23::x24::x25::x26::x27::x28::x29::x30::x31::xs) =
	[x0,x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,x12,x13,x14,x15,
	x16,x17,x18,x19,x20,x21,x22,x23,x24,x25,x26,x27,x28,x29,x30,x31]::chunks xs
  | chunks (x::xs) = [];

fun sublist ([], n) = []
  | sublist (xs, 0) = []
  | sublist (x::xs, n) = x::sublist (xs, n - 1);

fun restlist ([], n) = []
  | restlist (xs, 0) = xs
  | restlist (x::xs, n) = restlist (xs, n - 1);

fun dividechunks cs = if length cs > 16
	then
		sublist (cs, 16)::dividechunks (restlist (cs, 16))
	else
		[cs];

fun sha1parte1 s =
let
	val binarymsg = List.concat (map tobinario (map ord (explode s)))
in
	dividechunks (chunks ((add0s (add (binarymsg, #"1")))
	@ tobinario64 (length binarymsg)))
end;

fun xor ([],[]) = []
  | xor (x::xs,y::ys) = if (x = #"1" andalso y = #"0")
	orelse (x = #"0" andalso y = #"1")
		then #"1"::xor (xs,ys)
	else
		#"0"::xor (xs,ys)
  | xor (xs, []) = []
  | xor ([], ys) = [];

fun leftrotate (x::xs) = add (xs, x)
  | leftrotate [] = [];

fun sha1parte2aux (x1,x2,x3,x4) = leftrotate (xor (xor (x1,x2), xor (x3,x4)));

fun sha1parte2 chunk =
let
	val i = ref 16
	val palavras = ref chunk
in
	while (!i < 80) do 
	(palavras := add (!palavras, sha1parte2aux (List.nth (!palavras, !i-3),
	List.nth (!palavras, !i-8), List.nth (!palavras, !i-14), List.nth (!palavras, !i-16)));
	i := !i + 1);
	!palavras
end;

fun not [] = []
  | not (#"0"::cs) = #"1"::not cs
  | not (#"1"::cs) = #"0"::not cs
  | not cs = [];

fun or ([],[]) = []
  | or (x::xs, y::ys) = if x = #"0" andalso y = #"0"
	then
		#"0"::or (xs, ys)
	else
		#"1"::or (xs, ys)
  | or (xs, []) = []
  | or ([], ys) = [];

fun andlogic ([],[]) = []
  | andlogic (x::xs, y::ys) = if x = #"1" andalso y = #"1"
	then
		#"1"::andlogic (xs, ys)
	else
		#"0"::andlogic (xs, ys)
  | andlogic (xs, []) = []
  | andlogic ([], ys) = [];

fun lrot (cs, 0) = cs
  | lrot (cs, n) = lrot (leftrotate cs, n - 1);

fun additionrev ([],[],0) = []
  | additionrev ([],[],1) = [#"1"]
  | additionrev (#"0"::xs, #"0"::ys, 0) = #"0"::additionrev (xs, ys, 0)
  | additionrev (#"0"::xs, #"0"::ys, 1) = #"1"::additionrev (xs, ys, 0)
  | additionrev (#"0"::xs, #"1"::ys, 0) = #"1"::additionrev (xs, ys, 0)
  | additionrev (#"1"::xs, #"0"::ys, 0) = #"1"::additionrev (xs, ys, 0)
  | additionrev (#"1"::xs, #"1"::ys, 0) = #"0"::additionrev (xs, ys, 1)
  | additionrev (#"0"::xs, #"1"::ys, 1) = #"0"::additionrev (xs, ys, 1)
  | additionrev (#"1"::xs, #"0"::ys, 1) = #"0"::additionrev (xs, ys, 1)
  | additionrev (#"1"::xs, #"1"::ys, 1) = #"1"::additionrev (xs, ys, 1)
  | additionrev (#"0"::xs, [], 0) = #"0"::additionrev (xs, [], 0)
  | additionrev ([], #"0"::ys, 0) = #"0"::additionrev ([], ys, 0)
  | additionrev (#"0"::xs, [], 1) = #"1"::additionrev (xs, [], 0)
  | additionrev ([], #"0"::ys, 1) = #"1"::additionrev ([], ys, 0)
  | additionrev (#"1"::xs, [], 0) = #"1"::additionrev (xs, [], 0)
  | additionrev ([], #"1"::ys, 0) = #"1"::additionrev ([], ys, 0)
  | additionrev (#"1"::xs, [], 1) = #"0"::additionrev (xs, [], 1)
  | additionrev ([], #"1"::ys, 1) = #"0"::additionrev ([], ys, 1)
  | additionrev (xs,ys,n) = [];

fun addition (xs,ys) = rev (additionrev (rev xs, rev ys, 0));

fun fun1f (b,c,d) = or (andlogic (b,c), andlogic ((not b),d));

fun fun2f (b,c,d) = xor (xor (b,c), d);

fun fun3f (b,c,d) = or (or (andlogic (b,c), andlogic (b,d)), andlogic (c,d));

fun fun4f (b,c,d) = xor (xor (b,c), d);

fun nontruncatedtemp (a,f,e,k,palavra) =
	addition (addition (addition (lrot (a,5), f), addition (e,k)), palavra);

fun truncate palavra = restlist (palavra, (length palavra) - 32);

fun sha1parte3 (palavras, h0, h1, h2, h3, h4) =
let
	val a = ref h0
	val b = ref h1
	val c = ref h2
	val d = ref h3
	val e = ref h4
	val i = ref 0
	val palavra = ref []
	val fun1k =
	[#"0", #"1", #"0", #"1", #"1", #"0", #"1", #"0", #"1", #"0", #"0", #"0",
	#"0", #"0", #"1", #"0", #"0", #"1", #"1", #"1", #"1", #"0", #"0", #"1",
	#"1", #"0", #"0", #"1", #"1", #"0", #"0", #"1"]
	val fun2k =
	[#"0", #"1", #"1", #"0", #"1", #"1", #"1", #"0", #"1", #"1", #"0", #"1",
	#"1", #"0", #"0", #"1", #"1", #"1", #"1", #"0", #"1", #"0", #"1", #"1",
	#"1", #"0", #"1", #"0", #"0", #"0", #"0", #"1"]
	val fun3k =
	[#"1", #"0", #"0", #"0", #"1", #"1", #"1", #"1", #"0", #"0", #"0", #"1",
	#"1", #"0", #"1", #"1", #"1", #"0", #"1", #"1", #"1", #"1", #"0", #"0",
	#"1", #"1", #"0", #"1", #"1", #"1", #"0", #"0"]
	val fun4k =
	[#"1", #"1", #"0", #"0", #"1", #"0", #"1", #"0", #"0", #"1", #"1", #"0",
	#"0", #"0", #"1", #"0", #"1", #"1", #"0", #"0", #"0", #"0", #"0", #"1",
	#"1", #"1", #"0", #"1", #"0", #"1", #"1", #"0"]
	val f = ref []
	val temp = ref []
in
	while (!i < 20) do
	(palavra := List.nth (palavras, !i);
	f := fun1f (!b,!c,!d);
	temp := truncate (nontruncatedtemp (!a,!f,!e,fun1k,!palavra));
	e := !d;
	d := !c;
	c := lrot (!b, 30);
	b := !a;
	a := !temp;
	i := !i + 1);
	while (!i < 40) do
	(palavra := List.nth (palavras, !i);
	f := fun2f (!b,!c,!d);
	temp := truncate (nontruncatedtemp (!a,!f,!e,fun2k,!palavra));
	e := !d;
	d := !c;
	c := lrot (!b, 30);
	b := !a;
	a := !temp;
	i := !i + 1);
	while (!i < 60) do
	(palavra := List.nth (palavras, !i);
	f := fun3f (!b,!c,!d);
	temp := truncate (nontruncatedtemp (!a,!f,!e,fun3k,!palavra));
	e := !d;
	d := !c;
	c := lrot (!b, 30);
	b := !a;
	a := !temp;
	i := !i + 1);
	while (!i < 80) do
	(palavra := List.nth (palavras, !i);
	f := fun4f (!b,!c,!d);
	temp := truncate (nontruncatedtemp (!a,!f,!e,fun4k,!palavra));
	e := !d;
	d := !c;
	c := lrot (!b, 30);
	b := !a;
	a := !temp;
	i := !i + 1);
	[truncate (addition (h0,!a)), truncate (addition (h1,!b)),
	truncate (addition (h2,!c)), truncate (addition (h3,!d)),
	truncate (addition (h4,!e))]
end;

fun tohexatable [#"0",#"0",#"0",#"0"] = #"0"
  | tohexatable [#"0",#"0",#"0",#"1"] = #"1"
  | tohexatable [#"0",#"0",#"1",#"0"] = #"2"
  | tohexatable [#"0",#"0",#"1",#"1"] = #"3"
  | tohexatable [#"0",#"1",#"0",#"0"] = #"4"
  | tohexatable [#"0",#"1",#"0",#"1"] = #"5"
  | tohexatable [#"0",#"1",#"1",#"0"] = #"6"
  | tohexatable [#"0",#"1",#"1",#"1"] = #"7"
  | tohexatable [#"1",#"0",#"0",#"0"] = #"8"
  | tohexatable [#"1",#"0",#"0",#"1"] = #"9"
  | tohexatable [#"1",#"0",#"1",#"0"] = #"a"
  | tohexatable [#"1",#"0",#"1",#"1"] = #"b"
  | tohexatable [#"1",#"1",#"0",#"0"] = #"c"
  | tohexatable [#"1",#"1",#"0",#"1"] = #"d"
  | tohexatable [#"1",#"1",#"1",#"0"] = #"e"
  | tohexatable [#"1",#"1",#"1",#"1"] = #"f"
  | tohexatable cs = #"?";

fun tohexaaux cs =
let
	val resto = (length cs) mod 4
in
	if resto = 0
		then cs
	else if resto = 1
		then #"0"::(#"0"::(#"0"::cs))
	else if resto = 2
		then #"0"::(#"0"::cs)
	else
		#"0"::cs
end;

fun tohexaaux2 [] = []
  | tohexaaux2 cs = (tohexatable (sublist (cs, 4)))::tohexaaux2 (restlist (cs, 4));

fun tohexa cs = tohexaaux2 (tohexaaux cs);

fun sha1parte4 (chunk::[], h0, h1, h2, h3, h4) =
implode (List.concat (map tohexa (sha1parte3 (sha1parte2 chunk, h0, h1, h2, h3, h4))))
  | sha1parte4 (chunk::chunks, h0, h1, h2, h3, h4) =
let
	val hs = sha1parte3 (sha1parte2 chunk, h0, h1, h2, h3, h4)
	val h0novo = List.nth (hs, 0)
	val h1novo = List.nth (hs, 1)
	val h2novo = List.nth (hs, 2)
	val h3novo = List.nth (hs, 3)
	val h4novo = List.nth (hs, 4)
in
	sha1parte4 (chunks, h0novo, h1novo, h2novo, h3novo, h4novo)
end
  | sha1parte4 (chunks, h0, h1, h2, h3, h4) = "";

fun sha1 s =
let
	val chunks = sha1parte1 s
	val h0 =
	[#"0", #"1", #"1", #"0", #"0", #"1", #"1", #"1", #"0", #"1", #"0", #"0",
	#"0", #"1", #"0", #"1", #"0", #"0", #"1", #"0", #"0", #"0", #"1", #"1",
	#"0", #"0", #"0", #"0", #"0", #"0", #"0", #"1"]
	val h1 =
	[#"1", #"1", #"1", #"0", #"1", #"1", #"1", #"1", #"1", #"1", #"0", #"0",
	#"1", #"1", #"0", #"1", #"1", #"0", #"1", #"0", #"1", #"0", #"1", #"1",
	#"1", #"0", #"0", #"0", #"1", #"0", #"0", #"1"]
	val h2 =
	[#"1", #"0", #"0", #"1", #"1", #"0", #"0", #"0", #"1", #"0", #"1", #"1",
	#"1", #"0", #"1", #"0", #"1", #"1", #"0", #"1", #"1", #"1", #"0", #"0",
	#"1", #"1", #"1", #"1", #"1", #"1", #"1", #"0"]
	val h3 =
	[#"0", #"0", #"0", #"1", #"0", #"0", #"0", #"0", #"0", #"0", #"1", #"1",
	#"0", #"0", #"1", #"0", #"0", #"1", #"0", #"1", #"0", #"1", #"0", #"0",
	#"0", #"1", #"1", #"1", #"0", #"1", #"1", #"0"]
	val h4 =
	[#"1", #"1", #"0", #"0", #"0", #"0", #"1", #"1", #"1", #"1", #"0", #"1",
	#"0", #"0", #"1", #"0", #"1", #"1", #"1", #"0", #"0", #"0", #"0", #"1",
	#"1", #"1", #"1", #"1", #"0", #"0", #"0", #"0"]
in
	sha1parte4 (chunks, h0, h1, h2, h3, h4)
end;

(* --------------------------------------------------------------------------------- *)
(*										     *)
(* --------------------------------- MINERA/VALIDA --------------------------------- *)

fun gerahash (hashanterior, dados, nonce) = sha1 (hashanterior ^ Int.toString nonce ^ dados);

fun zeros n =
let
	val counter = ref 0
	val value = ref ""
in
	while (!counter < n) do 
	(counter := !counter + 1; 
	value := !value ^ "0");
	!value
end;

fun mineraraux (dificuldade, hashanterior, dados, nonce) =
let
	val hash = gerahash (hashanterior, dados, nonce)
in
	if dificuldade = substring (hash, 0, size dificuldade)
		then {h=hash, n=nonce}
	else
		mineraraux (dificuldade, hashanterior, dados, nonce + 1)
end;

fun minerar (dificuldade, hashanterior, dados) =
let
	val dif = zeros dificuldade;
in
	mineraraux (dif, hashanterior, dados, 0)
end;

fun isvalido ([], dificuldade) = true
  | isvalido (c::[], dificuldade) =
let
	val hashanterior = gethashanterior c
	val hash = gethash c
	val hashanteriorreal = ""
	val hashreal = gerahash (hashanteriorreal, getdados c, getnonce c)
in
	hashanterior = hashanteriorreal
	andalso hash = hashreal
	andalso (String.isPrefix (zeros dificuldade) hash)
end
  | isvalido (c::ca::cs, dificuldade) =
let
	val hashanterior = gethashanterior c
	val hash = gethash c
	val hashanteriorreal = gethash ca
	val hashreal = gerahash (hashanteriorreal, getdados c, getnonce c)
in
	hashanterior = hashanteriorreal
	andalso hash = hashreal
	andalso (String.isPrefix (zeros dificuldade) hash)
	andalso isvalido (ca::cs, dificuldade)
end;

fun adulteracadeia [] = []
  | adulteracadeia (b::[]) =
let
	val hash = gethash b
	val hashanterior = gethashanterior b
	val dados = "Bloco adulterado!!!"
	val nonce = getnonce b
in
	[{hash, hashanterior, dados, nonce}]
end
  | adulteracadeia (b::bs) = b::adulteracadeia bs;

(* -------------------------------------------------------------------------------- *)
(*										    *)
(* ------------------------------------- MAIN ------------------------------------- *)

fun main entrada =
let
	val dificuldade = 2
	val cadeiaoriginal = fromjson (ler entrada)
	val validaoriginal = Bool.toString (isvalido (cadeiaoriginal, dificuldade))
	val dados = "Dados do novo bloco"
	val hashanterior = gethash (getultimobloco cadeiaoriginal)
	val hashenonce = minerar (dificuldade, hashanterior, dados)
	val hash = #h hashenonce
	val nonce = #n hashenonce
	val novobloco = {hash, hashanterior, dados, nonce}:bloco
	val novacadeia = addbloco (novobloco, cadeiaoriginal)
	val validanova = Bool.toString (isvalido (novacadeia, dificuldade))
	val cadeiaadulterada = adulteracadeia novacadeia
	val invalida = Bool.toString (isvalido (cadeiaadulterada, dificuldade))
	val file1 = "cadeiaoriginal.json"
	val file2 = "novacadeia.json"
	val file3 = "cadeiaadulterada.json"
	val _ = escrever (file1, tojson cadeiaoriginal)
	val _ = escrever (file2, tojson novacadeia)
	val _ = escrever (file3, tojson cadeiaadulterada)
in
	print ("Blockchain original validada: " ^ validaoriginal ^
	"\nNova blockchain validada: " ^ validanova ^
	"\nBlockchain falsa validada: " ^ invalida ^
	"\nBlockchain Original:\n" ^ (ler file1) ^
	"\nNova Blockchain:\n" ^ (ler file2) ^
	"\nBlockchain Adulterada\n" ^ (ler file3))
end;

(*
val _ = main "teste1.json";
val _ = main "teste2.json";
val _ = main "teste3.json";
val _ = main "teste4.json";
val _ = main "teste5.json";
*)

(* -------------------------------------------------------------------------------- *)
(*										    *)
(* -------------------------------------------------------------------------------- *)
