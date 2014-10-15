#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ(2.61)
AC_INIT(tesla, 1.0, tela@expedia.com)
AC_LANG(C++)
AM_INIT_AUTOMAKE([1.9 foreign])
AC_CONFIG_SRCDIR([test])
AC_CONFIG_HEADER([config.h])
AC_CONFIG_MACRO_DIR([m4])

# Checks for programs.
AC_PROG_CXX

# Checks for libraries.
AC_CHECK_HEADER(cstdint)
AM_PATH_CPPUNIT(1.10.2)
if test x"${CPPUNIT_LIBS}" == x"" ; then
	AC_MSG_ERROR([CPPUNIT version 1.10.2 or higher is not found.])
fi
AX_BOOST_BASE([1.53],,[AC_MSG_ERROR([Tesla needs Boost, but it was not found in your system])])
AX_BOOST_IOSTREAMS

# Checks for header files.
AC_HEADER_STDC

# Checks for typedefs, structures, and compiler characteristics.
AC_HEADER_STDBOOL
AC_C_CONST
AC_TYPE_INT16_T
AC_TYPE_INT32_T
AC_TYPE_INT64_T
AC_TYPE_INT8_T
AC_TYPE_SIZE_T
AC_TYPE_UINT16_T
AC_TYPE_UINT32_T
AC_TYPE_UINT64_T
AC_TYPE_UINT8_T

# Checks for library functions.

AC_MSG_CHECKING([for boost shared ptr])
AC_COMPILE_IFELSE([
	AC_LANG_PROGRAM(
		[[#include <boost/shared_ptr.hpp>]],
		[[boost::shared_ptr<int> p;]])
	], [
		AC_MSG_RESULT([yes])
		AC_DEFINE([SHAREDPTR_BOOST],[1],[Use Boost implementation of shared_ptr])
	], [
		AC_MSG_RESULT([no])
		AC_MSG_ERROR([Could not find Boost implementation of shared_ptr])
])

AX_CXX_COMPILE_STDCXX_0X
if test  "$ax_cv_cxx_compile_cxx0x_cxx" = yes ||
	test "$ax_cv_cxx_compile_cxx0x_gxx" = yes; then
	CXXFLAGS="$CXXFLAGS -std=c++0x"
fi

AC_CONFIG_FILES([Makefile
                 test/Makefile])
AC_OUTPUT

