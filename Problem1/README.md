Problem1: Draw a swoosh
========

After seeing the problem, my first thought was trying to find simple rules like symmetrical, linear relation etc. 
However I found this is impractical since the picture or the logo is very irregular, there was no way I can use simple 
way to find the rule.

Then I thought about how the logo actually formed - by drawing several curves to form the swoosh.
There were several observations I found:
* The height is half of the width.
* Ignoring the bottom right blank, basically it is an ellipse.
* The bottom right can be treated as parabola curves to mimic.
* By observing the pattern, the bottom right part has 2 different parabolas have the same left point, if using my parabola model.

So the entire logo is within the oval area and left to the parabolas curves.
Since using this way I can simply test every pixcel if it is within the area, I decided to code this way.

So after several attempt trials, I formed the coordinate functions to discribe the curves of the picture.

(x - a)^2 / a^2  + (y - b)^2 / b^2 < 1  (in the code for potential overflow, I did the division first)

(and 2 parabola functions which are too complicated to write here)

Also in my code I used a 2D array to store the charactors, which is not neccesary to use the space if just need to draw on console. 
However since this is for potential use on the website to store everyone's information, I used the array to store the information.

Here is my code [```Swoosh.java```](https://github.com/southpenguin/SHouse/blob/master/Problem1/Swoosh.java)

Some snapshots from the results:

Width = 6

![Width = 6](https://github.com/southpenguin/SHouse/blob/master/Problem1/Snapshot/6.png?raw=true)


=======

Width = 9

![Width = 9](https://github.com/southpenguin/SHouse/blob/master/Problem1/Snapshot/9.png?raw=true)


=======

Width = 16

![Width = 16](https://github.com/southpenguin/SHouse/blob/master/Problem1/Snapshot/16.png?raw=true)

=======

Width = 20

![Width = 20](https://github.com/southpenguin/SHouse/blob/master/Problem1/Snapshot/20.png?raw=true)

=======

Width = 25

![Width = 25](https://github.com/southpenguin/SHouse/blob/master/Problem1/Snapshot/25.png?raw=true)

=======

Width = 32

![Width = 32](https://github.com/southpenguin/SHouse/blob/master/Problem1/Snapshot/32.png?raw=true)

=======

Width = 50

![Width = 50](https://github.com/southpenguin/SHouse/blob/master/Problem1/Snapshot/50.png?raw=true)

=======

Width = 64

![Width = 64](https://github.com/southpenguin/SHouse/blob/master/Problem1/Snapshot/64.png?raw=true)

=======

Width = 100

![Width = 100](https://github.com/southpenguin/SHouse/blob/master/Problem1/Snapshot/100.png?raw=true)

=======

Width = 200

![Width = 200](https://github.com/southpenguin/SHouse/blob/master/Problem1/Snapshot/200.png?raw=true)

=======

With a higher number of pixels, it looks very similar to the swoosh logo already. 
If I can put more time to find a better function to describe the curve, it will basically look the same.
