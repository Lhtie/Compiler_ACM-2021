	.text
	.file	"BuiltIn.c"
	.globl	print                   # -- Begin function print
	.p2align	2
	.type	print,@function
print:                                  # @print
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	sw	a0, -16(s0)
	lw	a1, -16(s0)
	lui	a0, %hi(.L.str)
	addi	a0, a0, %lo(.L.str)
	call	printf
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end0:
	.size	print, .Lfunc_end0-print
	.cfi_endproc
                                        # -- End function
	.globl	println                 # -- Begin function println
	.p2align	2
	.type	println,@function
println:                                # @println
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	sw	a0, -16(s0)
	lw	a1, -16(s0)
	lui	a0, %hi(.L.str.1)
	addi	a0, a0, %lo(.L.str.1)
	call	printf
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end1:
	.size	println, .Lfunc_end1-println
	.cfi_endproc
                                        # -- End function
	.globl	printInt                # -- Begin function printInt
	.p2align	2
	.type	printInt,@function
printInt:                               # @printInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	sw	a0, -12(s0)
	lw	a1, -12(s0)
	lui	a0, %hi(.L.str.2)
	addi	a0, a0, %lo(.L.str.2)
	call	printf
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end2:
	.size	printInt, .Lfunc_end2-printInt
	.cfi_endproc
                                        # -- End function
	.globl	printlnInt              # -- Begin function printlnInt
	.p2align	2
	.type	printlnInt,@function
printlnInt:                             # @printlnInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	sw	a0, -12(s0)
	lw	a1, -12(s0)
	lui	a0, %hi(.L.str.3)
	addi	a0, a0, %lo(.L.str.3)
	call	printf
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end3:
	.size	printlnInt, .Lfunc_end3-printlnInt
	.cfi_endproc
                                        # -- End function
	.globl	getString               # -- Begin function getString
	.p2align	2
	.type	getString,@function
getString:                              # @getString
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	addi	a0, zero, 256
	mv	a1, zero
	call	malloc
	sw	a0, -16(s0)
	lw	a1, -16(s0)
	lui	a0, %hi(.L.str)
	addi	a0, a0, %lo(.L.str)
	call	__isoc99_scanf
	lw	a0, -16(s0)
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end4:
	.size	getString, .Lfunc_end4-getString
	.cfi_endproc
                                        # -- End function
	.globl	getInt                  # -- Begin function getInt
	.p2align	2
	.type	getInt,@function
getInt:                                 # @getInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	lui	a0, %hi(.L.str.2)
	addi	a0, a0, %lo(.L.str.2)
	addi	a1, s0, -12
	call	__isoc99_scanf
	lw	a0, -12(s0)
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end5:
	.size	getInt, .Lfunc_end5-getInt
	.cfi_endproc
                                        # -- End function
	.globl	toString                # -- Begin function toString
	.p2align	2
	.type	toString,@function
toString:                               # @toString
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -48
	.cfi_def_cfa_offset 48
	sw	ra, 44(sp)
	sw	s0, 40(sp)
	sw	s1, 36(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	.cfi_offset s1, -12
	addi	s0, sp, 48
	.cfi_def_cfa s0, 0
	sw	a0, -16(s0)
	sw	zero, -20(s0)
	lw	a0, -16(s0)
	addi	a1, zero, -1
	blt	a1, a0, .LBB6_2
	j	.LBB6_1
.LBB6_1:
	addi	a0, zero, 1
	sw	a0, -20(s0)
	lw	a0, -16(s0)
	neg	a0, a0
	sw	a0, -16(s0)
	j	.LBB6_2
.LBB6_2:
	addi	s1, zero, 1
	addi	a0, zero, 1
	mv	a1, zero
	call	malloc
	sw	a0, -24(s0)
	lw	a0, -24(s0)
	sb	zero, 0(a0)
	sw	s1, -28(s0)
	j	.LBB6_3
.LBB6_3:                                # =>This Inner Loop Header: Depth=1
	lw	a0, -28(s0)
	addi	a0, a0, 1
	sw	a0, -28(s0)
	srai	a1, a0, 31
	call	malloc
	sw	a0, -32(s0)
	lw	a0, -32(s0)
	sb	zero, 1(a0)
	lw	a0, -32(s0)
	addi	a0, a0, 1
	lw	a1, -24(s0)
	call	strcpy
	lw	a0, -16(s0)
	lui	a1, 419430
	addi	s1, a1, 1639
	mulh	a1, a0, s1
	srli	a2, a1, 31
	srli	a1, a1, 2
	add	a1, a1, a2
	addi	a2, zero, 10
	mul	a1, a1, a2
	sub	a0, a0, a1
	addi	a0, a0, 48
	lw	a1, -32(s0)
	sb	a0, 0(a1)
	lw	a0, -24(s0)
	call	free
	lw	a0, -32(s0)
	sw	a0, -24(s0)
	lw	a0, -16(s0)
	mulh	a0, a0, s1
	srli	a1, a0, 31
	srai	a0, a0, 2
	add	a0, a0, a1
	sw	a0, -16(s0)
	j	.LBB6_4
.LBB6_4:                                #   in Loop: Header=BB6_3 Depth=1
	lw	a0, -16(s0)
	bnez	a0, .LBB6_3
	j	.LBB6_5
.LBB6_5:
	lw	a0, -20(s0)
	beqz	a0, .LBB6_7
	j	.LBB6_6
.LBB6_6:
	lw	a0, -28(s0)
	addi	a0, a0, 1
	sw	a0, -28(s0)
	srai	a1, a0, 31
	call	malloc
	sw	a0, -40(s0)
	lw	a0, -40(s0)
	sb	zero, 1(a0)
	lw	a0, -40(s0)
	addi	a0, a0, 1
	lw	a1, -24(s0)
	call	strcpy
	lw	a0, -40(s0)
	addi	a1, zero, 45
	sb	a1, 0(a0)
	lw	a0, -24(s0)
	call	free
	lw	a0, -40(s0)
	sw	a0, -24(s0)
	j	.LBB6_7
.LBB6_7:
	lw	a0, -24(s0)
	lw	s1, 36(sp)
	lw	s0, 40(sp)
	lw	ra, 44(sp)
	addi	sp, sp, 48
	ret
.Lfunc_end6:
	.size	toString, .Lfunc_end6-toString
	.cfi_endproc
                                        # -- End function
	.globl	array_size              # -- Begin function array_size
	.p2align	2
	.type	array_size,@function
array_size:                             # @array_size
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	sw	a0, -16(s0)
	lw	a0, -16(s0)
	lw	a0, -4(a0)
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end7:
	.size	array_size, .Lfunc_end7-array_size
	.cfi_endproc
                                        # -- End function
	.globl	string_length           # -- Begin function string_length
	.p2align	2
	.type	string_length,@function
string_length:                          # @string_length
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	sw	a0, -16(s0)
	lw	a0, -16(s0)
	call	strlen
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end8:
	.size	string_length, .Lfunc_end8-string_length
	.cfi_endproc
                                        # -- End function
	.globl	string_subString        # -- Begin function string_subString
	.p2align	2
	.type	string_subString,@function
string_subString:                       # @string_subString
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -48
	.cfi_def_cfa_offset 48
	sw	ra, 44(sp)
	sw	s0, 40(sp)
	sw	s1, 36(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	.cfi_offset s1, -12
	addi	s0, sp, 48
	.cfi_def_cfa s0, 0
	sw	a0, -16(s0)
	sw	a1, -20(s0)
	sw	a2, -24(s0)
	addi	s1, zero, 1
	addi	a0, zero, 1
	mv	a1, zero
	call	malloc
	sw	a0, -32(s0)
	lw	a0, -32(s0)
	sb	zero, 0(a0)
	lw	a0, -20(s0)
	sw	a0, -36(s0)
	sw	s1, -40(s0)
	j	.LBB9_1
.LBB9_1:                                # =>This Inner Loop Header: Depth=1
	lw	a0, -36(s0)
	lw	a1, -24(s0)
	bge	a0, a1, .LBB9_4
	j	.LBB9_2
.LBB9_2:                                #   in Loop: Header=BB9_1 Depth=1
	lw	a0, -40(s0)
	addi	a0, a0, 1
	sw	a0, -40(s0)
	srai	a1, a0, 31
	call	malloc
	sw	a0, -48(s0)
	lw	a0, -48(s0)
	sb	zero, 0(a0)
	lw	a0, -48(s0)
	lw	a1, -32(s0)
	call	strcpy
	lw	a0, -16(s0)
	lw	a1, -36(s0)
	add	a0, a0, a1
	lb	a0, 0(a0)
	lw	a1, -48(s0)
	lw	a2, -40(s0)
	add	a1, a2, a1
	sb	a0, -2(a1)
	lw	a0, -48(s0)
	lw	a1, -40(s0)
	add	a0, a1, a0
	sb	zero, -1(a0)
	lw	a0, -32(s0)
	call	free
	lw	a0, -48(s0)
	sw	a0, -32(s0)
	j	.LBB9_3
.LBB9_3:                                #   in Loop: Header=BB9_1 Depth=1
	lw	a0, -36(s0)
	addi	a0, a0, 1
	sw	a0, -36(s0)
	j	.LBB9_1
.LBB9_4:
	lw	a0, -32(s0)
	lw	s1, 36(sp)
	lw	s0, 40(sp)
	lw	ra, 44(sp)
	addi	sp, sp, 48
	ret
.Lfunc_end9:
	.size	string_subString, .Lfunc_end9-string_subString
	.cfi_endproc
                                        # -- End function
	.globl	string_parseInt         # -- Begin function string_parseInt
	.p2align	2
	.type	string_parseInt,@function
string_parseInt:                        # @string_parseInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 32
	.cfi_def_cfa s0, 0
	sw	a0, -16(s0)
	sw	zero, -20(s0)
	sb	zero, -21(s0)
	lw	a0, -16(s0)
	lb	a0, 0(a0)
	addi	a1, zero, 45
	bne	a0, a1, .LBB10_2
	j	.LBB10_1
.LBB10_1:
	addi	a0, zero, 1
	sb	a0, -21(s0)
	lw	a0, -16(s0)
	addi	a0, a0, 1
	sw	a0, -16(s0)
	j	.LBB10_2
.LBB10_2:
	j	.LBB10_3
.LBB10_3:                               # =>This Inner Loop Header: Depth=1
	lw	a0, -16(s0)
	lb	a0, 0(a0)
	beqz	a0, .LBB10_10
	j	.LBB10_4
.LBB10_4:                               #   in Loop: Header=BB10_3 Depth=1
	lw	a0, -16(s0)
	lb	a0, 0(a0)
	addi	a1, zero, 48
	blt	a0, a1, .LBB10_7
	j	.LBB10_5
.LBB10_5:                               #   in Loop: Header=BB10_3 Depth=1
	lw	a0, -16(s0)
	lb	a0, 0(a0)
	addi	a1, zero, 57
	blt	a1, a0, .LBB10_7
	j	.LBB10_6
.LBB10_6:                               #   in Loop: Header=BB10_3 Depth=1
	lw	a0, -20(s0)
	addi	a1, zero, 10
	mul	a0, a0, a1
	lw	a1, -16(s0)
	lb	a1, 0(a1)
	add	a0, a1, a0
	addi	a0, a0, -48
	sw	a0, -20(s0)
	j	.LBB10_8
.LBB10_7:
	j	.LBB10_11
.LBB10_8:                               #   in Loop: Header=BB10_3 Depth=1
	j	.LBB10_9
.LBB10_9:                               #   in Loop: Header=BB10_3 Depth=1
	lw	a0, -16(s0)
	addi	a0, a0, 1
	sw	a0, -16(s0)
	j	.LBB10_3
.LBB10_10:                              # %.loopexit
	j	.LBB10_11
.LBB10_11:
	lw	a0, -20(s0)
	lbu	a1, -21(s0)
	andi	a2, a1, 1
	addi	a1, zero, -1
	bnez	a2, .LBB10_13
# %bb.12:
	addi	a1, zero, 1
.LBB10_13:
	mul	a0, a0, a1
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end10:
	.size	string_parseInt, .Lfunc_end10-string_parseInt
	.cfi_endproc
                                        # -- End function
	.globl	string_ord              # -- Begin function string_ord
	.p2align	2
	.type	string_ord,@function
string_ord:                             # @string_ord
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 32
	.cfi_def_cfa s0, 0
	sw	a0, -16(s0)
	sw	a1, -20(s0)
	lw	a0, -16(s0)
	lw	a1, -20(s0)
	add	a0, a0, a1
	lb	a0, 0(a0)
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end11:
	.size	string_ord, .Lfunc_end11-string_ord
	.cfi_endproc
                                        # -- End function
	.globl	string_add              # -- Begin function string_add
	.p2align	2
	.type	string_add,@function
string_add:                             # @string_add
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -48
	.cfi_def_cfa_offset 48
	sw	ra, 44(sp)
	sw	s0, 40(sp)
	sw	s1, 36(sp)
	sw	s2, 32(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	.cfi_offset s1, -12
	.cfi_offset s2, -16
	addi	s0, sp, 48
	.cfi_def_cfa s0, 0
	sw	a0, -24(s0)
	sw	a1, -32(s0)
	lw	a0, -24(s0)
	call	strlen
	mv	s1, a0
	mv	s2, a1
	lw	a0, -32(s0)
	call	strlen
	add	a1, s2, a1
	add	a2, s1, a0
	sltu	a0, a2, s1
	add	a1, a1, a0
	addi	a0, a2, 1
	sltu	a2, a0, a2
	add	a1, a1, a2
	call	malloc
	sw	a0, -40(s0)
	lw	a0, -40(s0)
	sb	zero, 0(a0)
	lw	a0, -40(s0)
	lw	a1, -24(s0)
	call	strcat
	lw	a0, -40(s0)
	lw	a1, -32(s0)
	call	strcat
	lw	a0, -40(s0)
	lw	s2, 32(sp)
	lw	s1, 36(sp)
	lw	s0, 40(sp)
	lw	ra, 44(sp)
	addi	sp, sp, 48
	ret
.Lfunc_end12:
	.size	string_add, .Lfunc_end12-string_add
	.cfi_endproc
                                        # -- End function
	.globl	string_eq               # -- Begin function string_eq
	.p2align	2
	.type	string_eq,@function
string_eq:                              # @string_eq
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 32
	.cfi_def_cfa s0, 0
	sw	a0, -16(s0)
	sw	a1, -24(s0)
	lw	a0, -16(s0)
	lw	a1, -24(s0)
	call	strcmp
	seqz	a0, a0
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end13:
	.size	string_eq, .Lfunc_end13-string_eq
	.cfi_endproc
                                        # -- End function
	.globl	string_ne               # -- Begin function string_ne
	.p2align	2
	.type	string_ne,@function
string_ne:                              # @string_ne
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 32
	.cfi_def_cfa s0, 0
	sw	a0, -16(s0)
	sw	a1, -24(s0)
	lw	a0, -16(s0)
	lw	a1, -24(s0)
	call	strcmp
	snez	a0, a0
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end14:
	.size	string_ne, .Lfunc_end14-string_ne
	.cfi_endproc
                                        # -- End function
	.globl	string_lt               # -- Begin function string_lt
	.p2align	2
	.type	string_lt,@function
string_lt:                              # @string_lt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 32
	.cfi_def_cfa s0, 0
	sw	a0, -16(s0)
	sw	a1, -24(s0)
	lw	a0, -16(s0)
	lw	a1, -24(s0)
	call	strcmp
	srli	a0, a0, 31
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end15:
	.size	string_lt, .Lfunc_end15-string_lt
	.cfi_endproc
                                        # -- End function
	.globl	string_le               # -- Begin function string_le
	.p2align	2
	.type	string_le,@function
string_le:                              # @string_le
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 32
	.cfi_def_cfa s0, 0
	sw	a0, -16(s0)
	sw	a1, -24(s0)
	lw	a0, -16(s0)
	lw	a1, -24(s0)
	call	strcmp
	slti	a0, a0, 1
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end16:
	.size	string_le, .Lfunc_end16-string_le
	.cfi_endproc
                                        # -- End function
	.globl	string_gt               # -- Begin function string_gt
	.p2align	2
	.type	string_gt,@function
string_gt:                              # @string_gt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 32
	.cfi_def_cfa s0, 0
	sw	a0, -16(s0)
	sw	a1, -24(s0)
	lw	a0, -16(s0)
	lw	a1, -24(s0)
	call	strcmp
	sgtz	a0, a0
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end17:
	.size	string_gt, .Lfunc_end17-string_gt
	.cfi_endproc
                                        # -- End function
	.globl	string_ge               # -- Begin function string_ge
	.p2align	2
	.type	string_ge,@function
string_ge:                              # @string_ge
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 32
	.cfi_def_cfa s0, 0
	sw	a0, -16(s0)
	sw	a1, -24(s0)
	lw	a0, -16(s0)
	lw	a1, -24(s0)
	call	strcmp
	not	a0, a0
	srli	a0, a0, 31
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end18:
	.size	string_ge, .Lfunc_end18-string_ge
	.cfi_endproc
                                        # -- End function
	.type	.L.str,@object          # @.str
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str:
	.asciz	"%s"
	.size	.L.str, 3

	.type	.L.str.1,@object        # @.str.1
.L.str.1:
	.asciz	"%s\n"
	.size	.L.str.1, 4

	.type	.L.str.2,@object        # @.str.2
.L.str.2:
	.asciz	"%d"
	.size	.L.str.2, 3

	.type	.L.str.3,@object        # @.str.3
.L.str.3:
	.asciz	"%d\n"
	.size	.L.str.3, 4

	.ident	"clang version 10.0.0-4ubuntu1 "
	.section	".note.GNU-stack","",@progbits
