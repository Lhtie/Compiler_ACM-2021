	.text
	.file	"BuiltIn.c"
	.globl	print                   # -- Begin function print
	.p2align	4, 0x90
	.type	print,@function
print:                                  # @print
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	-8(%rbp), %rsi
	movabsq	$.L.str, %rdi
	movb	$0, %al
	callq	printf
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end0:
	.size	print, .Lfunc_end0-print
	.cfi_endproc
                                        # -- End function
	.globl	println                 # -- Begin function println
	.p2align	4, 0x90
	.type	println,@function
println:                                # @println
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	-8(%rbp), %rsi
	movabsq	$.L.str.1, %rdi
	movb	$0, %al
	callq	printf
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end1:
	.size	println, .Lfunc_end1-println
	.cfi_endproc
                                        # -- End function
	.globl	printInt                # -- Begin function printInt
	.p2align	4, 0x90
	.type	printInt,@function
printInt:                               # @printInt
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movl	%edi, -4(%rbp)
	movl	-4(%rbp), %esi
	movabsq	$.L.str.2, %rdi
	movb	$0, %al
	callq	printf
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end2:
	.size	printInt, .Lfunc_end2-printInt
	.cfi_endproc
                                        # -- End function
	.globl	printlnInt              # -- Begin function printlnInt
	.p2align	4, 0x90
	.type	printlnInt,@function
printlnInt:                             # @printlnInt
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movl	%edi, -4(%rbp)
	movl	-4(%rbp), %esi
	movabsq	$.L.str.3, %rdi
	movb	$0, %al
	callq	printf
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end3:
	.size	printlnInt, .Lfunc_end3-printlnInt
	.cfi_endproc
                                        # -- End function
	.globl	getString               # -- Begin function getString
	.p2align	4, 0x90
	.type	getString,@function
getString:                              # @getString
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$32, %rsp
	movl	$1, %edi
	callq	malloc
	movq	%rax, -24(%rbp)
	movq	-24(%rbp), %rax
	movb	$0, (%rax)
	movl	$1, -8(%rbp)
	movabsq	$.L.str.4, %rdi
	leaq	-1(%rbp), %rsi
	movb	$0, %al
	callq	__isoc99_scanf
.LBB4_1:                                # =>This Inner Loop Header: Depth=1
	movsbl	-1(%rbp), %eax
	cmpl	$10, %eax
	je	.LBB4_3
# %bb.2:                                #   in Loop: Header=BB4_1 Depth=1
	movl	-8(%rbp), %eax
	addl	$1, %eax
	movl	%eax, -8(%rbp)
	movslq	%eax, %rdi
	shlq	$0, %rdi
	callq	malloc
	movq	%rax, -16(%rbp)
	movq	-16(%rbp), %rax
	movb	$0, (%rax)
	movq	-16(%rbp), %rdi
	movq	-24(%rbp), %rsi
	callq	strcpy
	movb	-1(%rbp), %al
	movq	-16(%rbp), %rcx
	movl	-8(%rbp), %edx
	subl	$2, %edx
	movslq	%edx, %rdx
	movb	%al, (%rcx,%rdx)
	movq	-16(%rbp), %rax
	movl	-8(%rbp), %ecx
	subl	$1, %ecx
	movslq	%ecx, %rcx
	movb	$0, (%rax,%rcx)
	movq	-24(%rbp), %rdi
	callq	free
	movq	-16(%rbp), %rax
	movq	%rax, -24(%rbp)
	callq	getchar
	movb	%al, -1(%rbp)
	jmp	.LBB4_1
.LBB4_3:
	movq	-24(%rbp), %rax
	addq	$32, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end4:
	.size	getString, .Lfunc_end4-getString
	.cfi_endproc
                                        # -- End function
	.globl	getInt                  # -- Begin function getInt
	.p2align	4, 0x90
	.type	getInt,@function
getInt:                                 # @getInt
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movabsq	$.L.str.2, %rdi
	leaq	-4(%rbp), %rsi
	movb	$0, %al
	callq	__isoc99_scanf
	movl	-4(%rbp), %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end5:
	.size	getInt, .Lfunc_end5-getInt
	.cfi_endproc
                                        # -- End function
	.globl	toString                # -- Begin function toString
	.p2align	4, 0x90
	.type	toString,@function
toString:                               # @toString
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$48, %rsp
	movl	%edi, -4(%rbp)
	movl	$0, -20(%rbp)
	cmpl	$0, -4(%rbp)
	jge	.LBB6_2
# %bb.1:
	xorl	%eax, %eax
	movl	$1, -20(%rbp)
	subl	-4(%rbp), %eax
	movl	%eax, -4(%rbp)
.LBB6_2:
	movl	$1, %edi
	callq	malloc
	movq	%rax, -16(%rbp)
	movq	-16(%rbp), %rax
	movb	$0, (%rax)
	movl	$1, -8(%rbp)
.LBB6_3:                                # =>This Inner Loop Header: Depth=1
	movl	-8(%rbp), %eax
	addl	$1, %eax
	movl	%eax, -8(%rbp)
	movslq	%eax, %rdi
	shlq	$0, %rdi
	callq	malloc
	movq	%rax, -40(%rbp)
	movq	-40(%rbp), %rax
	movb	$0, 1(%rax)
	movq	-40(%rbp), %rdi
	addq	$1, %rdi
	movq	-16(%rbp), %rsi
	callq	strcpy
	movl	-4(%rbp), %eax
	cltd
	movl	$10, %ecx
	idivl	%ecx
	addl	$48, %edx
	movq	-40(%rbp), %rax
	movb	%dl, (%rax)
	movq	-16(%rbp), %rdi
	callq	free
	movq	-40(%rbp), %rax
	movq	%rax, -16(%rbp)
	movl	-4(%rbp), %eax
	cltd
	movl	$10, %ecx
	idivl	%ecx
	movl	%eax, -4(%rbp)
# %bb.4:                                #   in Loop: Header=BB6_3 Depth=1
	cmpl	$0, -4(%rbp)
	jne	.LBB6_3
# %bb.5:
	cmpl	$0, -20(%rbp)
	je	.LBB6_7
# %bb.6:
	movl	-8(%rbp), %eax
	addl	$1, %eax
	movl	%eax, -8(%rbp)
	movslq	%eax, %rdi
	shlq	$0, %rdi
	callq	malloc
	movq	%rax, -32(%rbp)
	movq	-32(%rbp), %rax
	movb	$0, 1(%rax)
	movq	-32(%rbp), %rdi
	addq	$1, %rdi
	movq	-16(%rbp), %rsi
	callq	strcpy
	movq	-32(%rbp), %rax
	movb	$45, (%rax)
	movq	-16(%rbp), %rdi
	callq	free
	movq	-32(%rbp), %rax
	movq	%rax, -16(%rbp)
.LBB6_7:
	movq	-16(%rbp), %rax
	addq	$48, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end6:
	.size	toString, .Lfunc_end6-toString
	.cfi_endproc
                                        # -- End function
	.globl	array_size              # -- Begin function array_size
	.p2align	4, 0x90
	.type	array_size,@function
array_size:                             # @array_size
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, -8(%rbp)
	movq	-8(%rbp), %rax
	movl	-4(%rax), %eax
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end7:
	.size	array_size, .Lfunc_end7-array_size
	.cfi_endproc
                                        # -- End function
	.globl	string_length           # -- Begin function string_length
	.p2align	4, 0x90
	.type	string_length,@function
string_length:                          # @string_length
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, -16(%rbp)
	movl	$0, -4(%rbp)
.LBB8_1:                                # =>This Inner Loop Header: Depth=1
	movq	-16(%rbp), %rax
	movsbl	(%rax), %eax
	cmpl	$0, %eax
	je	.LBB8_4
# %bb.2:                                #   in Loop: Header=BB8_1 Depth=1
	movl	-4(%rbp), %eax
	addl	$1, %eax
	movl	%eax, -4(%rbp)
# %bb.3:                                #   in Loop: Header=BB8_1 Depth=1
	movq	-16(%rbp), %rax
	addq	$1, %rax
	movq	%rax, -16(%rbp)
	jmp	.LBB8_1
.LBB8_4:
	movl	-4(%rbp), %eax
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end8:
	.size	string_length, .Lfunc_end8-string_length
	.cfi_endproc
                                        # -- End function
	.globl	string_subString        # -- Begin function string_subString
	.p2align	4, 0x90
	.type	string_subString,@function
string_subString:                       # @string_subString
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$48, %rsp
	movq	%rdi, -40(%rbp)
	movl	%esi, -32(%rbp)
	movl	%edx, -28(%rbp)
	movl	$1, %edi
	callq	malloc
	movq	%rax, -24(%rbp)
	movq	-24(%rbp), %rax
	movb	$0, (%rax)
	movl	-32(%rbp), %eax
	movl	%eax, -8(%rbp)
	movl	$1, -4(%rbp)
.LBB9_1:                                # =>This Inner Loop Header: Depth=1
	movl	-8(%rbp), %eax
	cmpl	-28(%rbp), %eax
	jge	.LBB9_4
# %bb.2:                                #   in Loop: Header=BB9_1 Depth=1
	movl	-4(%rbp), %eax
	addl	$1, %eax
	movl	%eax, -4(%rbp)
	movslq	%eax, %rdi
	shlq	$0, %rdi
	callq	malloc
	movq	%rax, -16(%rbp)
	movq	-16(%rbp), %rax
	movb	$0, (%rax)
	movq	-16(%rbp), %rdi
	movq	-24(%rbp), %rsi
	callq	strcpy
	movq	-40(%rbp), %rax
	movslq	-8(%rbp), %rcx
	movb	(%rax,%rcx), %al
	movq	-16(%rbp), %rcx
	movl	-4(%rbp), %edx
	subl	$2, %edx
	movslq	%edx, %rdx
	movb	%al, (%rcx,%rdx)
	movq	-16(%rbp), %rax
	movl	-4(%rbp), %ecx
	subl	$1, %ecx
	movslq	%ecx, %rcx
	movb	$0, (%rax,%rcx)
	movq	-24(%rbp), %rdi
	callq	free
	movq	-16(%rbp), %rax
	movq	%rax, -24(%rbp)
# %bb.3:                                #   in Loop: Header=BB9_1 Depth=1
	movl	-8(%rbp), %eax
	addl	$1, %eax
	movl	%eax, -8(%rbp)
	jmp	.LBB9_1
.LBB9_4:
	movq	-24(%rbp), %rax
	addq	$48, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end9:
	.size	string_subString, .Lfunc_end9-string_subString
	.cfi_endproc
                                        # -- End function
	.globl	string_parseInt         # -- Begin function string_parseInt
	.p2align	4, 0x90
	.type	string_parseInt,@function
string_parseInt:                        # @string_parseInt
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$32, %rsp
	movq	%rdi, -16(%rbp)
	movl	$0, -20(%rbp)
	movb	$0, -1(%rbp)
	movq	-16(%rbp), %rax
	movsbl	(%rax), %eax
	cmpl	$45, %eax
	jne	.LBB10_2
# %bb.1:
	movb	$1, -1(%rbp)
	movq	-16(%rbp), %rax
	addq	$1, %rax
	movq	%rax, -16(%rbp)
.LBB10_2:
	jmp	.LBB10_3
.LBB10_3:                               # =>This Inner Loop Header: Depth=1
	movq	-16(%rbp), %rax
	movsbl	(%rax), %eax
	cmpl	$0, %eax
	je	.LBB10_9
# %bb.4:                                #   in Loop: Header=BB10_3 Depth=1
	callq	__ctype_b_loc
	movq	(%rax), %rax
	movq	-16(%rbp), %rcx
	movsbl	(%rcx), %ecx
	movslq	%ecx, %rcx
	movzwl	(%rax,%rcx,2), %eax
	andl	$2048, %eax             # imm = 0x800
	cmpl	$0, %eax
	je	.LBB10_6
# %bb.5:                                #   in Loop: Header=BB10_3 Depth=1
	imull	$10, -20(%rbp), %eax
	movq	-16(%rbp), %rcx
	movsbl	(%rcx), %ecx
	subl	$48, %ecx
	addl	%ecx, %eax
	movl	%eax, -20(%rbp)
	jmp	.LBB10_7
.LBB10_6:
	jmp	.LBB10_10
.LBB10_7:                               #   in Loop: Header=BB10_3 Depth=1
	jmp	.LBB10_8
.LBB10_8:                               #   in Loop: Header=BB10_3 Depth=1
	movq	-16(%rbp), %rax
	addq	$1, %rax
	movq	%rax, -16(%rbp)
	jmp	.LBB10_3
.LBB10_9:                               # %.loopexit
	jmp	.LBB10_10
.LBB10_10:
	movl	-20(%rbp), %eax
	movb	-1(%rbp), %cl
	testb	$1, %cl
	movl	$4294967295, %ecx       # imm = 0xFFFFFFFF
	movl	$1, %edx
	cmovnel	%ecx, %edx
	imull	%edx, %eax
	addq	$32, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end10:
	.size	string_parseInt, .Lfunc_end10-string_parseInt
	.cfi_endproc
                                        # -- End function
	.globl	string_ord              # -- Begin function string_ord
	.p2align	4, 0x90
	.type	string_ord,@function
string_ord:                             # @string_ord
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, -16(%rbp)
	movl	%esi, -4(%rbp)
	movq	-16(%rbp), %rax
	movslq	-4(%rbp), %rcx
	movsbl	(%rax,%rcx), %eax
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end11:
	.size	string_ord, .Lfunc_end11-string_ord
	.cfi_endproc
                                        # -- End function
	.globl	string_add              # -- Begin function string_add
	.p2align	4, 0x90
	.type	string_add,@function
string_add:                             # @string_add
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%rbx
	subq	$24, %rsp
	.cfi_offset %rbx, -24
	movq	%rdi, -32(%rbp)
	movq	%rsi, -24(%rbp)
	movq	-32(%rbp), %rdi
	callq	strlen
	movq	%rax, %rbx
	movq	-24(%rbp), %rdi
	callq	strlen
	addq	%rax, %rbx
	addq	$1, %rbx
	shlq	$0, %rbx
	movq	%rbx, %rdi
	callq	malloc
	movq	%rax, -16(%rbp)
	movq	-16(%rbp), %rax
	movb	$0, (%rax)
	movq	-16(%rbp), %rdi
	movq	-32(%rbp), %rsi
	callq	strcat
	movq	-16(%rbp), %rdi
	movq	-24(%rbp), %rsi
	callq	strcat
	movq	-16(%rbp), %rax
	addq	$24, %rsp
	popq	%rbx
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end12:
	.size	string_add, .Lfunc_end12-string_add
	.cfi_endproc
                                        # -- End function
	.globl	string_eq               # -- Begin function string_eq
	.p2align	4, 0x90
	.type	string_eq,@function
string_eq:                              # @string_eq
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -16(%rbp)
	movq	%rsi, -8(%rbp)
	movq	-16(%rbp), %rdi
	movq	-8(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	sete	%al
	andb	$1, %al
	movzbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end13:
	.size	string_eq, .Lfunc_end13-string_eq
	.cfi_endproc
                                        # -- End function
	.globl	string_ne               # -- Begin function string_ne
	.p2align	4, 0x90
	.type	string_ne,@function
string_ne:                              # @string_ne
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -16(%rbp)
	movq	%rsi, -8(%rbp)
	movq	-16(%rbp), %rdi
	movq	-8(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	setne	%al
	andb	$1, %al
	movzbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end14:
	.size	string_ne, .Lfunc_end14-string_ne
	.cfi_endproc
                                        # -- End function
	.globl	string_lt               # -- Begin function string_lt
	.p2align	4, 0x90
	.type	string_lt,@function
string_lt:                              # @string_lt
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -16(%rbp)
	movq	%rsi, -8(%rbp)
	movq	-16(%rbp), %rdi
	movq	-8(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	setl	%al
	andb	$1, %al
	movzbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end15:
	.size	string_lt, .Lfunc_end15-string_lt
	.cfi_endproc
                                        # -- End function
	.globl	string_le               # -- Begin function string_le
	.p2align	4, 0x90
	.type	string_le,@function
string_le:                              # @string_le
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -16(%rbp)
	movq	%rsi, -8(%rbp)
	movq	-16(%rbp), %rdi
	movq	-8(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	setle	%al
	andb	$1, %al
	movzbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end16:
	.size	string_le, .Lfunc_end16-string_le
	.cfi_endproc
                                        # -- End function
	.globl	string_gt               # -- Begin function string_gt
	.p2align	4, 0x90
	.type	string_gt,@function
string_gt:                              # @string_gt
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -16(%rbp)
	movq	%rsi, -8(%rbp)
	movq	-16(%rbp), %rdi
	movq	-8(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	setg	%al
	andb	$1, %al
	movzbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end17:
	.size	string_gt, .Lfunc_end17-string_gt
	.cfi_endproc
                                        # -- End function
	.globl	string_ge               # -- Begin function string_ge
	.p2align	4, 0x90
	.type	string_ge,@function
string_ge:                              # @string_ge
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -16(%rbp)
	movq	%rsi, -8(%rbp)
	movq	-16(%rbp), %rdi
	movq	-8(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	setge	%al
	andb	$1, %al
	movzbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
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

	.type	.L.str.4,@object        # @.str.4
.L.str.4:
	.asciz	" %c"
	.size	.L.str.4, 4

	.ident	"clang version 10.0.0-4ubuntu1 "
	.section	".note.GNU-stack","",@progbits
