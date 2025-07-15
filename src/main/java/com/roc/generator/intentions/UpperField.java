package com.roc.generator.intentions;

import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.codeInsight.intention.PsiElementBaseIntentionAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nls.Capitalization;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * 将自动变为大写
 *
 * @author 鱼蛮 Date 2025/7/15
 */
public class UpperField extends PsiElementBaseIntentionAction implements IntentionAction {

    @NotNull
    @Override
    public String getText() {
        return "Upper field";
    }

    @Override
    public @NotNull @Nls(capitalization = Capitalization.Sentence) String getFamilyName() {
        return "Upper field";
    }

    @Override
    public void invoke(@NotNull Project project, Editor editor, @NotNull PsiElement element) throws IncorrectOperationException {
        PsiField field = Objects.requireNonNull(PsiTreeUtil.getContextOfType(element, PsiField.class));
//        PsiElementFactory factory = PsiElementFactory.getInstance(project);
//        PsiElement anchor = field.getChildren()[1];
//        PsiKeyword keyword =  factory.createKeyword("final");
//        field.addAfter(keyword, anchor);
//        field.addBefore(factory.createKeyword("static"), keyword);

        field.setName(field.getName().toUpperCase());
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, @NotNull PsiElement element) {
        if (!(element instanceof PsiJavaToken)) {
            return false;
        }
        PsiField field = PsiTreeUtil.getContextOfType(element, PsiField.class);
        return !Objects.isNull(field);
    }

}
