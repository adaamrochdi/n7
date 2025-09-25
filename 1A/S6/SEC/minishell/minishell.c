#include <stdio.h>
#include <stdlib.h>
#include "readcmd.h"
#include <unistd.h>     // fork, getpid, getppid
#include <stdbool.h>
#include <string.h>
#include <sys/wait.h>



void executerCommande(char **cmd) {
    pid_t pid = fork();
    int status;

    if (pid == -1) {
        perror("Erreur fork");
        exit(EXIT_FAILURE);
    } else if (pid == 0) {
        // Processus fils : tente d'exécuter la commande
        if (execvp(cmd[0], cmd) == -1) {
            perror("Erreur execvp");
            exit(EXIT_FAILURE);
        }
    } else {
        // Processus père : attend la fin du processus fils
        pid_t pidFils;
        if ((pidFils = wait(&status)) != -1) {
            if (WIFEXITED(status)) {
                printf("Le processus fils %d s'est terminé avec le code %d\n", pidFils, WEXITSTATUS(status));
            } else if (WIFSIGNALED(status)) {
                printf("Le processus fils %d s'est terminé par le signal %d\n", pidFils, WTERMSIG(status));
            }
        }
    }
}

int main(void) {
    bool fini= false;

    while (!fini) {
        printf("> ");
        struct cmdline *commande= readcmd();

        if (commande == NULL) {
            // commande == NULL -> erreur readcmd()
            perror("erreur lecture commande \n");
            exit(EXIT_FAILURE);
    
        } else {

            if (commande->err) {
                // commande->err != NULL -> commande->seq == NULL
                printf("erreur saisie de la commande : %s\n", commande->err);
        
            } else {

                /* Pour le moment le programme ne fait qu'afficher les commandes 
                   tapees et les affiche à l'écran. 
                   Cette partie est à modifier pour considérer l'exécution de ces
                   commandes 
                */
                int indexseq= 0;
                char **cmd;
                while ((cmd= commande->seq[indexseq])) {
                    if (cmd[0]) {
                        if (strcmp(cmd[0], "exit") == 0) {
                            fini= true;
                            printf("Au revoir ...\n");
                        }
                        else {executerCommande(cmd);
                        }

                        indexseq++;
                    }
                }
            }
        }
    }
    return EXIT_SUCCESS;
}
