bash remove.sh
echo "Развитые способности Unburden" > accelgor4
echo -e "Живет\nMarsh" > marshtomp6
mkdir octillery7
echo -e "Ходы Conversion\u2260\n
Conversion2\u2260 Dark Pulse Double-Edge Electroweb Foul Play Gravity Icy Wind Iron Tail Last Resort Magic Coat Magnet Rise Mimic Nasty Plot\u2260 Pain Split Recycle Role Play Shock Wave Signal Beam Sleep Talk Snore Swift Trick Trick Room\u2260 Uproar Wonder Room Zen\nHeadbutt" > porygonz9
mkdir shelmet5
mkdir wobbuffet9
echo "Возможности Overland=4 Jump=1 Power=2 Intelligence=3 Sprouter=0 Sinker=0" > octillery7/ferroseed
mkdir octillery7/lucario
echo "Возможности Overland=7 Surface=3 Jump=2 Power=2 Intelligence=7 Aura=0 Telekinetic=0 Telepath=0" > octillery7/alakazam
echo "Возможности Overland=3 Power=1 Intelligence=4 Sinker=0 Telekinetic=0 Telepath=0" > octillery7/abra
mkdir octillery7/sandshrew
mkdir shelmet5/spearow
echo "Способности Focus Guts No Guard" > shelmet5/machamp
echo -e "satk=7\nsdef=5 spd=5" > shelmet5/chingling
echo -e "Развитые способности\nInfiltrator" > wobbuffet9/golbat
echo "Способности Pound Growl Helping Hand Tickle Doubleslap Encore Swift Sing Tail Slap Charm Wake-up Slap Echoed Voice Slam Captivate Hyper Voice Resort After You" > wobbuffet9/minccino
echo "Способности Supersonic Constrict Acid Toxic Spikes Bubblebeam Wrap Barrier Water Pulse Poison Jab Hex Hydro Pump Sludge Wave Wring Out" > wobbuffet9/tentacruel
mkdir wobbuffet9/froslass
mkdir wobbuffet9/gothorita
mkdir wobbuffet9/sandile

# TASK 2
chmod 404 accelgor4
chmod 664 marshtomp6
chmod 555 octillery7
chmod =r--r----- octillery7/ferroseed
chmod =-wxrw--wx octillery7/lucario
chmod =r-------- octillery7/alakazam
chmod =r--r----- octillery7/abra
chmod =-wx-wxr-x octillery7/sandshrew
chmod 664 porygonz9
chmod =rwxrw-rw- shelmet5
chmod =rwx-wx-wx shelmet5/spearow
chmod =rw------- shelmet5/machamp
chmod =rw--w-r-- shelmet5/chingling
chmod 330 wobbuffet9
chmod =---rw--w- wobbuffet9/golbat
chmod =---r--r-- wobbuffet9/minccino
chmod 315 wobbuffet9/froslass
chmod =rw--w--w- wobbuffet9/tentacruel
chmod =-wx-wxr-x wobbuffet9/gothorita
chmod 550 wobbuffet9/sandile

# TASK 3

chmod =rwx wobbuffet9/gothorita
cp marshtomp6 wobbuffet9/gothorita
chmod =-wx-wxr-x wobbuffet9/gothorita


chmod =rwx wobbuffet9
chmod =rwx wobbuffet9/golbat
chmod =rwx wobbuffet9/minccino
chmod =rwx wobbuffet9/froslass
chmod =rwx wobbuffet9/tentacruel
chmod =rwx wobbuffet9/gothorita
chmod =rwx wobbuffet9/sandile
chmod =rwx shelmet5/spearow
cp -r wobbuffet9 shelmet5/spearow
chmod 330 wobbuffet9
chmod =---rw--w- wobbuffet9/golbat
chmod =---r--r-- wobbuffet9/minccino
chmod 315 wobbuffet9/froslass
chmod =rw--w--w- wobbuffet9/tentacruel
chmod =-wx-wxr-x wobbuffet9/gothorita
chmod 550 wobbuffet9/sandile
chmod =rwx-wx-wx shelmet5/spearow

chmod =rwx shelmet5/chingling
chmod =rwx octillery7/ferroseed
cat shelmet5/chingling octillery7/ferroseed > accelgor4_96
chmod =rw--w-r-- shelmet5/chingling
chmod =r--r----- octillery7/ferroseed

chmod =rwx octillery7
ln accelgor4 octillery7/ferroseedaccelgor
chmod 555 octillery7

ln -s wobbuffet9 Copy_19
ln -s marshtomp6 wobbuffet9/minccinomarshtomp

chmod =rwx shelmet5
cat porygonz9 > shelmet5/chinglingporygonz
chmod =rwxrw-rw- shelmet5

chmod -R =rwx ../lab0


# TASK 4
Echo "--1--"
ls -R | grep "^s" | wc -m | sort
Echo "--2--"
ls -ltr | head -n4 | tail -n3
Echo "--3--"
cat -n wobbuffet9/* | grep -iv "Sla" 2>1
Echo "--4--"
ls -Ral | sort -k6 | grep "^-" | grep " [sS][a-zA-Z0-9]*$" 2>1
Echo "--5--"
ls -Ral | grep "^-" | grep " [gG][a-zA-Z0-9]*$" | tail -n4 | sort -k6 
Echo "--6--"
ls -Ral | grep "^-" | grep " [sS][a-zA-Z0-9]*$" | head -n4 | sort -k5


# TASK 5

rm marshtomp6
rm shelmet5/chingling
rm Copy_*
rm octillery7/ferroseedaccelg*
rm -r wobbuffet9/
rmdir octillery7/lucario


