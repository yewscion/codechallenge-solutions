dnl Process this file with autoconf
AC_INIT([codechallenge-solutions],[0.0.1],[yewscion@gmail.com],[codechallenge-solutions-0.0.1.tar.bz2],[https://github.com/yewscion/codechallenge-solutions])

dnl General Project Variables
AC_SUBST(HVERSION, "\"0.0.1\"")
AC_SUBST(AUTHOR, "\"Christopher Rodriguez\"")
AC_SUBST(COPYRIGHT, "'(2022)")
AC_SUBST(LICENSE, agpl3+)
AC_CONFIG_SRCDIR([README.md])
AC_CONFIG_AUX_DIR([build-aux])

dnl Set Up Automake
AM_INIT_AUTOMAKE([-Wall -Werror -Wportability gnu check-news dist-bzip2 filename-length-max=99
std-options])

dnl Set Up Guile 3.0
GUILE_PKG([3.0])
GUILE_PROGS
if test "x$GUILD" = "x"; then
   AC_MSG_ERROR(['guild' binary not found;
   please check Your guile installation.])
fi
GUILE_SITE_DIR

dnl Set Up Java
AC_PROG_CC
AX_CHECK_CLASSPATH
AX_PROG_JAVA_CC
AX_PROG_JAVAC
AX_PROG_JAVA
AX_PROG_JAR
AX_PROG_JAVADOC
AC_SUBST(MYJAVAPKG, "codechallenges")

dnl Checks for classes
dnl AX_CHECK_RQRD_CLASS(org.whatever)

dnl Installation directories for .scm and .go files.
guilemoduledir="${datarootdir}/guile/site/$GUILE_EFFECTIVE_VERSION"
guileobjectdir="${libdir}/guile/$GUILE_EFFECTIVE_VERSION/site-ccache"
AC_SUBST([guilemoduledir])
AC_SUBST([guileobjectdir])

dnl Finishing Up
AC_PROG_LN_S
AC_PROG_MKDIR_P
AC_CONFIG_FILES([Makefile])
AC_CONFIG_FILES([pre-inst-env], [chmod +x pre-inst-env])
AC_CONFIG_FILES([bin/codechallenge-info],[chmod +x bin/codechallenge-info])
AC_OUTPUT
