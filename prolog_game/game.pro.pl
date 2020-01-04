%
% http://www.amzi.com/manuals/samples/prolog/duckworld/
%
%
:- dynamic(loc/2).

% http://www.amzi.com/manuals/samples/prolog/duckworld/dw_data.pro
nextto(pen, yard).
nextto(yard, house).
nextto(house, pond).
nextto(yard, pond).

loc(egg,pen).
loc(ducks,pen).
loc(you,pen).
loc(farmer,yard).
loc(fox,forest).

move(Item, Place) :-
	retract( loc(Item, _) ),
	assert( loc(Item,Place) ).


% http://www.amzi.com/manuals/samples/prolog/duckworld/dw_rules.pro
connect(X,Y) :-
        nextto(X,Y).
connect(X,Y) :-
        nextto(Y,X).

done :-
	loc(you, house),
	loc(egg, you),
	write("Thanks for getting the egg."), nl.

done :-
	loc(ducks, limbo),
	write("GAME OVER"), nl.

done :-
	loc(fox, limbo),
	write("Congratulations! You got rid of the threat that that evil fox represented!"),
	nl,
	write("You don't need to get the egg anymore. What you've done is more than enough!"),
	nl.

demons :-
	ducks,
	fox,
	farmer.

ducks :-
	loc(ducks, pen),
	loc(you, pen),
	move(ducks, yard),
	write("The ducks have run into the yard."), nl.
ducks :-
	loc(ducks, yard),
	loc(you, yard),
	move(ducks, pond),
	write("The ducks have run into the pond."), nl.
ducks.


fox :-
	loc(ducks, yard),
	loc(you, house),
	write("The fox has taken a duck."), nl.
fox.

farmer :-
    loc(you, yard),
    loc(farmer, yard),
    loc(ducks, X),
		loc(fox, Y),
    X \= limbo,
		Y \= limbo,
    write("The farmer says hello."), nl.
farmer.

goto(X) :-
	loc(you, L),
	connect(L, X),
	move(you, X),
	write("You are in the "), write(X), nl.

goto(_) :-
	write("You can't get there from here."), nl.

chase(ducks) :-
	loc(ducks, L),
	loc(you, L),
	move(ducks, pen),
	write("The ducks are back in their pen."), nl.
chase(_):-
	write("No ducks here."), nl.

take(X) :-
	loc(you, L),
	loc(X, L),
	move(X, you),
	write("You now have the "), write(X), nl.
take(X) :-
	write("There is no "), write(X), write(" here."), nl.

look :-
	write("You are in the "),
	loc(you, L), write(L), nl,
	look_connect(L),
	look_here(L),
	look_have(you).

look_connect(L) :-
	write("You can go to: "), nl,
	connect(L, CONNECT),
	write(" "), write(CONNECT), nl,
	fail.
look_connect(_).

look_have(X) :-
	write("You have: "), nl,
	loc(THING, X),
	write(" "), write(THING), nl,
	fail.
look_have(_).

look_here(L) :-
	write("You can see: "), nl,
	loc(THING, L),
	THING \= you,
	write(" "), write(THING), nl,
	fail.
look_here(_).

report :-
        findall(X:Y, loc(X,Y), L),
        write(L), nl.

attempt :-
	random(X),
	X >= 0.5.

kill(X) :-
	move(X, limbo).

miss :-
	write("Oh-oh! Looks like you missed it. Better luck next time!"),
	nl.

shoot(farmer) :-
	loc(you, yard),
	attempt,
	kill(farmer),
	write("Are you crazy!? You've shot the farmer, you bastard! Now he is dead!"),
	nl.

shoot(farmer) :-
	loc(you, yard),
	miss.

shoot(farmer) :-
	write("The farmer is not here."), nl.

shoot(ducks) :-
	loc(you, L),
	loc(ducks, L),
	attempt,
	kill(ducks),
	write("What are you doing!? You have killed your own ducks!"), nl.

shoot(ducks) :-
	loc(you, L),
	loc(ducks, L),
	miss.

shoot(ducks) :-
	write("The ducks are not here."), nl.

shoot(fox) :-
	loc(you, yard),
	attempt,
	kill(fox),
	write("Wow!!! Nice aim!!! You've just decimated that evil fox!"),
	nl.

shoot(fox) :-
	loc(you, yard),
	miss.

shoot(fox) :-
	write("The fox is not here."), nl.

shoot(_) :-
	write("You can't shoot that."), nl.

do(goto(X)) :- !, goto(X).
do(chase(X)) :- !, chase(X).
do(take(X)) :- !, take(X).
do(look) :- !, look.
do(help) :- !, instructions.
do(quit) :- !.
do(listing) :- !, listing.
do(report) :- !, report.
do(shoot(X)) :- !, shoot(X).
do(X) :- write("unknown command"), write(X), nl, instructions.

go :- done.
go :-
	write(">> "),
	read(X),
	X \= quit,
	do(X),
	demons,
	!, go.
go :- write(" Quitter "), nl.

instructions :-
	nl,
	write("You start in the house, the ducks and an egg"), nl,
	write("are in the pen.  You have to get the egg"), nl,
	write("without losing any ducks."), nl,
	nl,
	write("Enter commands at the prompt as Prolog terms"), nl,
	write("ending in period:"), nl,
	write("  goto(X). - where X is a place to go to."), nl,
	write("  shoot(X). - where X is your shooting target."), nl,
	write("  take(X). - where X is a thing to take."), nl,
	write("  chase(X). - chasing ducks sends them to the pen."), nl,
	write("  look. - the state of the game."), nl,
	write("  help. - this information."), nl,
	write("  quit. - exit the game."), nl,
	nl.

game :-
	write(" Welcome to Duck World "),nl,
	instructions,
	write(" Go get an egg "),nl,
	go.
