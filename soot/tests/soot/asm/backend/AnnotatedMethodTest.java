package soot.asm.backend;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.util.TraceClassVisitor;

/**
 * Test for annotations on methods
 *
 * @author Tobias Hamann, Florian Kuebler, Dominik Helm, Lukas Sommer
 *
 */
public class AnnotatedMethodTest extends AbstractASMBackendTest {

	@Override
	protected void generate(TraceClassVisitor cw) {

		
		MethodVisitor mv;
		AnnotationVisitor av0;

		cw.visit(V1_5, ACC_PUBLIC + ACC_SUPER, "soot/asm/backend/targets/AnnotatedMethod",
				null, "java/lang/Object", null);
		cw.visitSource("AnnotatedMethod.java", null);
		
		{
		mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitCode();
		mv.visitVarInsn(ALOAD, 0);
		mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
		mv.visitInsn(RETURN);
		mv.visitMaxs(0, 0);
		mv.visitEnd();
		}
		{
		mv = cw.visitMethod(ACC_PUBLIC, "doSth", "()V", null, null);
		{
		av0 = mv.visitAnnotation("Lsoot/asm/backend/targets/MyTestAnnotation;", true);
		av0.visit("iVal", new Integer(124));
		av0.visit("fVal", new Float("5132.0"));
		av0.visit("lVal", new Long(5123L));
		av0.visit("dVal", new Double("745.0"));
		av0.visit("zVal", Boolean.TRUE);
		av0.visit("bVal", new Byte((byte)1));
		av0.visit("sVal", new Short((short)123));
		av0.visit("strVal", "435243");
		av0.visit("rVal", Type.getType("Lsoot/asm/backend/targets/AnnotatedClass;"));
		av0.visit("iAVal", new int[] {123,234,345,456});
		{
		AnnotationVisitor av1 = av0.visitArray("sAVal");
		av1.visit(null, "A");
		av1.visit(null, "B");
		av1.visit(null, "C");
		av1.visitEnd();
		}
		av0.visitEnd();
		}
		mv.visitCode();
		mv.visitInsn(RETURN);
		mv.visitMaxs(0, 0);
		mv.visitEnd();
		}
		cw.visitEnd();


	}

	@Override
	protected String getTargetClass() {
		return "soot.asm.backend.targets.AnnotatedMethod";
	}

	@Override
	protected String getTargetFolder() {
		return "./testclasses";
	}

	@Override
	protected String getClassPathFolder() {
		return "./testclasses";
	}

}
