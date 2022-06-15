

# The `codechallenge-solutions` README

**Code Challenges and Solutions I've Created for Them.**

*Last Updated: 2022-06-15 (W24) 02:31:15 GMT*

This Repo is a collection of the code challenges I've completed over time, and
the solutions I've come up with for them. It's nothing serious, mostly just
something for me to look at and smile. For a list of the challenges I've
amassed, see the `Challenges.md` file!


# Installation


## GNU Guix

If You use [GNU Guix](https://guix.gnu.org/), this package 
is on [my channel](https://sr.ht/~yewscion/yewscion-guix-channel/). 

Once You have it set up, You can just run:

    guix pull
    guix install codechallenges

If You just want to try it out, You can use Guix Shell instead:

    guix shell codechallenges bash --pure

And if You'd rather just try it out without my channel, You can clone this
repo and then do:

    cd codechallenges
    guix shell -f guix.scm bash --pure

This'll create a profile with **just** this project in it, to mess around with.


## Source

If You don't want to use [GNU Guix](https://guix.gnu.org/),
You can clone this repo and install it in the normal way:

    git clone https://git.sr.ht/~yewscion/codechallenges
    cd codechallenges
    ./configure
    make
    make check
    make install

If You don't want to use git, or would rather stick with an
actual release, then see the tagged releases for some tarballs
of the source.

The needed dependencies are tracked in the DEPENDENCIES.txt file
to support this use case.


# Usage

Full usage is documented in the `doc/codechallenges.info` file. Here are
only generic instructions.

Once `codechallenges` in installed, You should be able to access all of
its exported functionsin guile by using its modules:

    (use-modules ( main))
    (library-info) ;; I include this in all my libraries

Any binaries or scripts will be available in Your `$PATH`. A list of these
is maintained in the info file. They all also have the `--help=` flag, so
if You prefer learning that way, that is also available.

This is mostly a toy repo, though it *is* a package that is installable. If I
create any tools, they'll be documented in the documentation.


# Contributing

Pull Requests are welcome, as are bugfixes and extensions. Please open
issues as needed. If You contribute a feature, needs to be tests and
documentation.

Development is expected to be done using [GNU Guix](https://guix.gnu.org/).
If You have `guix` set up, You should be able to enter a development
environment with the following:

    cd codechallenges
    guix shell -D -f guix.scm bash --pure

If You've made changes without the above precautions, those changes will
need to be confirmed to work in the above environment before merge.


# License

The `codechallenges` project and all associated files are ©2022 Christopher
Rodriguez, butlicensed to the public at large under the terms of the:

[GNU AGPL3.0+](https://www.gnu.org/licenses/agpl-3.0.html) license.

Please see the `LICENSE` file and the above link for more information.

All work that is not my own is not licensed under the above, and is instead
licensed under the original license of that work (mostly the prompts for the
challenges, which are in `.prompt` files and comments.

