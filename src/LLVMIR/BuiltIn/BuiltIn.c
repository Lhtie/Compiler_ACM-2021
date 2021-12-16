#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

void print(char *str){
    printf("%s", str);
}

void println(char *str){
    printf("%s\n", str);
}

void printInt(int n){
    printf("%d", n);
}

void printlnInt(int n){
    printf("%d\n", n);
}

char *getString(){
    char *ret = (char *) malloc(sizeof(char));
    *ret = '\0';
    int len = 1;
    char ch = getchar();
    while (ch != '\n') {
        char *tmp = (char *) malloc(sizeof(char) * (++len));
        tmp[0] = '\0';
        strcpy(tmp, ret);
        tmp[len-2] = ch, tmp[len-1] = '\0';
        free(ret);
        ret = tmp;
        ch = getchar();
    }
    return ret;
}

int getInt(){
    int ret;
    scanf("%d", &ret);
    return ret;
}

char *toString(int i){
    int neg = false;
    if (i < 0) neg = true, i = -i;
    char *ret = (char *) malloc(sizeof(char));
    *ret = '\0';
    int len = 1;
    do {
        char *tmp = (char *) malloc(sizeof(char) * (++len));
        tmp[1] = '\0';
        strcpy(tmp + 1, ret);
        tmp[0] = (char) (i % 10 + '0');
        free(ret);
        ret = tmp;
        i /= 10;
    } while (i);
    if (neg){
        char *tmp = (char *) malloc(sizeof(char) * (++len));
        tmp[1] = '\0';
        strcpy(tmp + 1, ret);
        tmp[0] = '-';
        free(ret);
        ret = tmp;
    }
    return ret;
}

int array_size(char *arr){
    return *((int *)(arr - 4));
}

int string_length(char *str){
    int ret = 0;
    for (; *str != '\0'; ++str)
        ret++;
    return ret;
}

char *string_subString(char *str, int left, int right){
    char *ret = (char *) malloc(sizeof(char));
    *ret = '\0';
    for (int i = left, len = 1; i < right; ++i){
        char *tmp = (char *) malloc(sizeof(char) * (++len));
        tmp[0] = '\0';
        strcpy(tmp, ret);
        tmp[len-2] = str[i], tmp[len-1] = '\0';
        free(ret);
        ret = tmp;
    }
    return ret;
}

int string_parseInt(char *str){
    int ret = 0;
    bool neg = false;
    if (*str == '-') neg = true, str++;
    for (; *str != '\0'; ++str) {
        if (isdigit(*str))
            ret = ret * 10 + (*str - '0');
        else break;
    }
    return ret * (neg ? -1 : 1);
}

int string_ord(char *str, int pos){
    return str[pos];
}

char *string_add(char *s1, char *s2){
    char *ret = (char *)malloc(sizeof(char) * (strlen(s1) + strlen(s2) + 1));
    *ret = '\0';
    strcat(ret, s1);
    strcat(ret, s2);
    return ret;
}

bool string_eq(char *s1, char *s2){
    return strcmp(s1, s2) == 0;
}

bool string_ne(char *s1, char *s2){
    return strcmp(s1, s2) != 0;
}

bool string_lt(char *s1, char *s2){
    return strcmp(s1, s2) < 0;
}

bool string_le(char *s1, char *s2){
    return strcmp(s1, s2) <= 0;
}

bool string_gt(char *s1, char *s2){
    return strcmp(s1, s2) > 0;
}

bool string_ge(char *s1, char *s2){
    return strcmp(s1, s2) >= 0;
}